package testEnum;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/23/16:41
 */
public enum SeasonEnum implements SeasonInterface{
    SPRING("春天","春天来了"){
        @Override
        public void show() {
            System.out.println("春天在哪里呀在哪里！！");
        }
    },
    SUMMER("夏天","夏天来了") {
        @Override
        public void show() {
            System.out.println("夏日炎炎当睡觉！！");
        }
    },
    AUTUMN("秋天","秋天来了") {
        @Override
        public void show() {
            System.out.println("落叶知秋！！");
        }
    },
    WINTER("冬天","冬天也来了") {
        @Override
        public void show() {
            System.out.println("寒冬凛冽!!!");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}
