package jdk8.stream;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/30/10:21
 */
public class Practice {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();

        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

    }

    @Test
    public void test2() {

        //迭代
        Stream<Integer> stream = Stream.iterate(0, x -> x + 2);
        stream.limit(10).forEach(s -> System.out.println(s));

        //生成
        Stream<Double> generate = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });
        generate.limit(10).forEach(s -> System.out.println(s));
    }

    @Test
    public void test3() {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        //中间操作之filter(Predicate p)
        IntStream stream = Arrays.stream(arr);
        stream.filter(s -> s >= 5).forEach(e -> System.out.println(e));
    }

    @Test
    public void test4() {
        Person first = new Person("关羽", 54);
        Person second = new Person("张飞", 53);
        Person three = new Person("赵云", 52);
        Person forth = new Person("黄忠", 51);
        Person fivth = new Person("马超", 50);
        ArrayList<Person> people = new ArrayList<>();
        people.add(first);
        people.add(second);
        people.add(three);
        people.add(forth);
        people.add(fivth);
        people.add(new Person("赵云", 52));

        people.stream().distinct().forEach(s -> System.out.println(s.getName()));
        people.stream().limit(3).forEach(s -> System.out.println(s.getName()));
        people.stream().skip(2).forEach(s -> System.out.println(s.getName()));

        System.out.println("===testMap=====");
        Stream<Person> stream = people.stream().map(new Function<Person, Person>() {
            @Override
            public Person apply(Person person) {
                if (person.getName().equals("赵云")) {
                    return person;
                }
                return new Person("王平", 24);
            }
        });
        stream.forEach(s -> System.out.println(s.getName()));

        System.out.println("===mapToDouble===");
        people.stream().mapToDouble(p -> {
            if (p.getName().equals("赵云")) {
                return 1;
            }
            return 0;
        }).forEach(s -> System.out.println(s));
    }

    @Test
    public void test5(){
        //终止操作之规约
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(reduce);
    }

    @Test
    public void test6(){
        //中间操作之排序
        List<Integer> list = Arrays.asList(11, 2, 32, 4, 5, 6, 71, 8, 94, 10);
        list.stream().sorted().forEach(s-> System.out.println(s));
    }

    @Test
    public void test7(){
        //终止操作之收集
        Person first = new Person("关羽", 54);
        Person second = new Person("张飞", 53);
        Person three = new Person("赵云", 52);
        Person forth = new Person("黄忠", 61);
        Person fivth = new Person("马超", 40);
        List<Person> peoples = new ArrayList<>();
        peoples.add(first);
        peoples.add(second);
        peoples.add(three);
        peoples.add(forth);
        peoples.add(fivth);

        //用stream配合Lambda表达式
        List<String> collect2 = peoples.stream().map(new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                if (person.getAge()>55){
                    return person.getName();
                }
                return null;
            }
        }).collect(Collectors.toList());

        //用新集合将旧集合中元素某个字段收集起来作为一个新集合
        List<String> collect = peoples.stream().map(e -> e.getName())
                .collect(Collectors.toList());
        List<Person> collect1 = peoples.stream().filter(s -> s.getAge() > 52)
                .collect(Collectors.toList());

        //allMath(Predicate p)--检查是否匹配所有元素
        boolean b = peoples.stream().allMatch(e -> e.getAge() > 40);

        //anyMatch(Predicate p)--检查是否至少匹配一个元素
        boolean b1 = peoples.stream().anyMatch(e -> e.getAge() > 45);

        //findFirst--返回第一个元素
        Optional<Person> first1 = peoples.stream().findFirst();

        //findAny--返回当前流中的任意元素
        Optional<Person> any = peoples.stream().findAny();

        //count--返回流中元素的总个数
        long count = peoples.stream().count();

        //max--返回流中的最大值
        //Optional<Person> max = people.stream().max((e1,e2)->e1.getAge()-e2.getAge());
        Optional<Person> max = peoples.stream().max(Comparator.comparingInt(Person::getAge));

        //min--返回流中的最小值
        Optional<Person> min = peoples.stream().min((e1, e2) -> e1.getAge() - e2.getAge());
    }

    @Test
    public void test8(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String s : list) {
            if ("2".equals(s)){
                list.remove(s);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test9(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if("3".equals(item)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void test10(){
        Map<String, Object> map = new HashMap<>();
        map.put("1", "曹操");
        map.put("2", "孙权");
        map.put("3", "刘备");
        map.put("2", "孙尚香");
        Object o = map.get("2");
        System.out.println(o);
    }

}
