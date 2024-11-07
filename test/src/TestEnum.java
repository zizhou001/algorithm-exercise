/**
 * @author zizhou
 * @create 2023-11-08 21:10
 */
enum Seasons{
    //1. 提供枚举类对象
    SPRING ("春","春天"),
    SUMMNER("夏","夏天"),
    AUTUMN ("秋","秋天"),
    WINTER ("冬","冬天");

    // 2.声明对象属性
    private final String seasonName;
    private final String seasonDesc;

    // 3.定义构造器

    private Seasons(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4.访问器
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

public class TestEnum {
    public static void main(String[] args) {
        Seasons summer = Seasons.SUMMNER;
        System.out.println(summer+summer.getSeasonName()+summer.getSeasonDesc());
    }
}
