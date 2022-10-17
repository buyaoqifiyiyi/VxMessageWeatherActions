package com.pt.vx.config;
import java.time.LocalDate;

import com.pt.vx.domain.BirthDay;
import com.pt.vx.domain.User;

import java.util.ArrayList;
import java.util.List;
/**
 * 内置的模板有：
 * 在微信模板里添加{{xxx.DATA}}
 *
 * 个人信息相关：
 * userName 昵称
 * holdDay 距离某天的天数
 * yourBirthDay 生日
 * myBirthDay 对象生日
 * loveDay 纪念日倒计时
 *
 * 天气相关：
 * date 日期
 * week 星期
 * weatherDay（1，2，3，4） 白天天气
 * temperatureDay（1，2，3，4）白天温度
 * windDay（1，2，3，4）白天风向
 * powerDay（1，2，3，4）白天风力
 * weatherNight（1，2，3，4） 晚上天气
 * temperatureNight（1，2，3，4） 晚上温度
 * windNight（1，2，3，4） 晚上风向
 * powerNight（1，2，3，4） 晚上风力
 * weatherNow 现在天气
 * temperatureNow 现在温度
 * windNow 现在风向
 * powerNow 现在风力
 * humidityNow 现在湿度
 *
 * 其他：（1、2、3、4......每100字一个，如tianGou超过了一百个字的话：{{tianGou.DATA}}{{tianGou1.DATA}}）
 * otherInfo 额外提示
 * randomRead 精彩短句
 * worldRead 世界新闻
 * tianGou 舔狗日记
 * qingHua 情话
 * english 励志英语
 * historyToday 历史的今天
 * horoscope 星座解析
 * randomInfo 随机额外类型消息
 * wozairenjian 我在人间凑日子散文
 * miyu 谜语
 * poetry 诗句
 * dongman 动漫
 * story 小说
 */
public class AllConfig {
    public static final String VxAppId = "wxf10a24cf10d78145";
    public static final String VxAppSecret = "ed2ab84611663fe192d8c8c53f1aa66f";
    public static final String WeatherKey = "4821081428f65b575e5d9092fad2084c";

    //基本类型消息
    public static final boolean open_info = true; //是否开启个人情况 true 为开启， false 为不开启
    public static final boolean open_weather = true; //是否开启天气预报
    public static final boolean open_other_info= true; //是否开启额外信息（需要开启个人情况和天气预报）

    //额外类型消息
    public static final boolean open_history_today = false; //是否开启历史上的今天
    public static final boolean open_qinghua = true; //是否开启情话一句
    public static final boolean open_dongman = true; //是否开启动漫台词
    public static final boolean open_tiangou = false; //是否开启舔狗日记
    public static final boolean open_world_read = false; //是否开启世界新闻
    public static final boolean open_random_read = true; //是否开启随机短句
    public static final boolean open_wozairenjian = false; //是否开启散文集我在人间凑日子
    public static final boolean open_poetry = false; //是否开启随机诗句
    public static final boolean open_english = false; //是否开启每日英语
    public static final boolean open_miyu = false; //是否开启谜语
    public static final boolean open_horoscope= false; //是否开启星座解析
    public static final boolean random_module = false; //随机一个开启了的额外类型消息(开启以后，只会推送随机的)

    //小说
    public static final boolean open_story = false; //开启小说,每天推送一章
    public static final String title = "西游记"; //小说名称
    public static final String author = "吴承恩"; //小说作者。用来过滤同名小说，没找到改作者默认取第一本
    public static final LocalDate start_time = LocalDate.of(2022,9,20);//第一次运行程序的时间，用来推断小说要看到第几章了



    private static void init(){
        //如果要多个人的话，就复制这个一遍，然后填写里面的内容。这里默认两个人,大伙应该是两个人吧（笑）
        userList.add(getUser(
                "ov-Gg6sCefcz8aoo3TYFtrcqUv_4",//扫码关注你的测试号以后，测试平台会出现TA的微信号
                "大红红公主",//咋称呼这个人
                new BirthDay(2004,9,1,false),  //这个人的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                new BirthDay(2003,5,20,false), //这个人对象的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                LocalDate.of(2022,9,7),//这个人的纪念日起点，比如说在一起的那一天
                "安徽滁州",//这个人的详细地址
                "滁州",//这个人在的城市
                "uX8XZD0nk3OUNooq_3_cF5iQaj24KUtOxR431BS04gM"));//要给这个人发送的模板ID
              
        userList.add(getUser(
                "ov-Gg6uvrC02yJQVL9Pp_Xx3csYQ",
                "一一",
                new BirthDay(2003,5,20,false),  //这个人的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                new BirthDay(2004,9,1,false), //这个人对象的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                LocalDate.of(2022,9,7),//这个人的纪念日
                "四川凉山",//这个人的详细地址
                "冕宁",//这个人在的城市
                "uX8XZD0nk3OUNooq_3_cF5iQaj24KUtOxR431BS04gM"));//要给这个人发送的模板ID

    
    }

    public static final List<User> userList = new ArrayList<>();
    static {
        init();
    }


    private static User getUser(String Vx, String username,
                                BirthDay birthday,
                                BirthDay careDay,
                                LocalDate loveDay,
                                String address, String city, String templateId){
        User user=new User();
        user.setVx(Vx);
        user.setUserName(username);
        user.setCareDay(careDay);
        user.setBirthDay(birthday);
        user.setLoveDay(loveDay);
        user.setAddress(address);
        user.setCity(city);
        user.setTemplateId(templateId);
        return user;
    }



}
