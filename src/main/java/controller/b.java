package controller;

import com.alibaba.fastjson.JSON;
import mybatis.Get;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class b {

    @GetMapping("/travel")//主页
    public String shouye(Model model){
        model.addAttribute("city", "北京");
        return "index";
    }
    @GetMapping(value = "/travelon")//传递城市主页
    public String chuandi(Model model, @RequestParam String city) {
        model.addAttribute("city", city);
        return "index";
    }
    @GetMapping("/ding")
    public String ding() {
        return "ding";
    }

    @GetMapping("/detail")
    public String detail() {
        return "1";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/listinfo/search")
    public String search(Model model, @RequestParam String content, @RequestParam String city, @RequestParam(name = "id", defaultValue = "1") String id) {
        String json = null;
        List list = null;
        int idx = Integer.valueOf(id);
        System.out.println(city);
        try {
            list = new Get().getword(content, city, idx);
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = JSON.toJSONString(list);
        model.addAttribute("json",json);
        //   System.out.println(content+"-!!"+city);
        return "listinfo";
    }

    @GetMapping("/listinfo/list")
    public String list(Model model, @RequestParam String country, @RequestParam String city, @RequestParam String type, @RequestParam String groupp, @RequestParam(name = "id", defaultValue = "1") String id) {
        String json = null;
        List list = null;
        int idx = Integer.valueOf(id);
        try {
            list = new Get().findmore(country, city,type, groupp, idx);
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = JSON.toJSONString(list);
        System.out.println(json);
        model.addAttribute("json", json);
        //System.out.println(country+"-"+city+"-type: "+type+"groupp: "+groupp);
        return "listinfo";
    }

    @GetMapping("/user")
    public String user(Model model) throws IOException {
        model.addAttribute("json",new Get().user());
        return "user";
    }

    @GetMapping("/view")
    public String view(Model model) throws IOException {
        model.addAttribute("json",new Get().scenic());
        return "view";
    }

    @GetMapping("/dingdan")
    public String dingdan(Model model){
        model.addAttribute("json");
        return "dingdan";
    }

}
