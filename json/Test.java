package json;

public class Test {

    //    private static final String test_json = "{\"icon_url\":\"http://h0.hucdn.com/open201932/1317487d13384669_60x36.png\",\"atmosphere_icon_url\":\"http://h0.hucdn.com/open/201848/a24058f636f6e149_750x128.png\",\"icon_width\":60,\"icon_height\":36,\"search_tip\":\"抢优惠券可减90！爆款空气炸锅低至209\",\"user_login_type\":2}";
    private static final String test_json = "{\"message\":\"\",\"success\":true,\"data\":[{\"name\":\"店主推荐\",\"name_en\":\"seller_recommend\",\"weex\":{\"target\":\"bb/base/weex\",\"url\":\"https://weex.beidian.com/dist/weex/shop/home.js\",\"hide_nav_bar\":1,\"hide_status_view\":1},\"h5\":{\"target\":\"bb/base/webview\",\"url\":\"https://m.beidian.com/findcommunity/moments.html\",\"hide_nav_bar\":1,\"hide_status_view\":1}},{\"name\":\"今日特卖\",\"name_en\":\"mart_home\"},{\"name\":\"新品\",\"name_en\":\"new_items\"},{\"name\":\"服饰\",\"name_en\":\"dress\",\"img\":{\"img_url\":\"\"}},{\"name\":\"母婴\",\"name_en\":\"baby\"},{\"name\":\"美食\",\"name_en\":\"food\"},{\"name\":\"居家\",\"name_en\":\"life\"},{\"name\":\"生鲜\",\"name_en\":\"fruit\"},{\"name\":\"美妆\",\"name_en\":\"makeups\"},{\"name\":\"数码\",\"name_en\":\"digit\"},{\"name\":\"最后疯抢\",\"name_en\":\"final_sale\"},{\"name\":\"贝店周边\",\"name_en\":\"bdzb\"}],\"user_login_type\":1}";

    public static void main(String[] args) throws Exception {
        Tokenizer tokenizer = new Tokenizer(test_json);
        Object map = Parser.parserValue(tokenizer);
        System.out.println(map);

    }
}