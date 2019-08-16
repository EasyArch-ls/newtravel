package controller;

import com.alibaba.fastjson.JSON;
import hpage.First;
import mybatis.Get;
import mybatis.bean.Managers;
import mybatis.bean.Order;
import mybatis.bean.Scenic;
import mybatis.bean.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class A {
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody Managers managers) {
        String json = null;
        try {
            json = new Get().findmaneger(managers.getName(), managers.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /* @RequestMapping(value = "index", method = RequestMethod.POST)
     public String first() {
         String json = null;
         try {
             json = new First().firstpage();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return json;
     }
 */
    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String travelon(@RequestBody String city) {
        System.out.println(city);
        Map map = JSON.parseObject(city, Map.class);
        city = (String) map.get("city");
        System.out.println(city);
        String json = null;
        try {
            json = new First().firstpage(city);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "loginto", method = RequestMethod.POST)
    public String loginto(@RequestBody User user) {
        String word = null;
        try {
            System.out.println(user.getUname()+"-"+user.getPassword());
            word = new Get().finduser(user.getUname(), user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        String word = null;
        try {
            word = new Get().registeruser(user.getUname(), user.getName(), user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }

    @RequestMapping(value = "addorder", method = RequestMethod.POST)
    public boolean addorder(@RequestBody Order order) {
        boolean b = false;
        try {
            b = new Get().addorder(order.getName(), order.getPhone(), order.getGender(), order.getEmail(), order.getId(),  order.getNumbers(), order.getPrice(), order.getOther());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    @RequestMapping(value = "userview", method = RequestMethod.GET)
    public String userview(@RequestParam(name = "name") String name, @RequestParam(name = "id", defaultValue = "1") String id) {
        int idx = Integer.valueOf(id);
        String json = null;
        try {
            json = JSON.toJSONString(new Get().userview(name, idx), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "managerview", method = RequestMethod.GET)
    public String userview(@RequestParam(name = "id", defaultValue = "1") String id) {
        int idx = Integer.valueOf(id);
        String json = null;
        try {
            json = JSON.toJSONString(new Get().managerview(idx), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "addscenic", method = RequestMethod.POST)
    public String addscenic(@RequestBody Scenic scenic) {
        String s=null;
        try {
             s=new Get().addscenic(scenic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }


    @RequestMapping(value = "xgscenic", method = RequestMethod.POST)
    public String xgscenic(@RequestBody Scenic scenic) {
        String s=null;
        try {
            s=new Get().xgscenic(scenic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @RequestMapping(value = "delscenic" ,method = RequestMethod.POST)
    public String delscenic(@RequestBody Scenic scenic){
        String s=null;
        try {
            s=new Get().descenic(scenic.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }



//    @RequestMapping(value = "search", method = RequestMethod.GET)
//    public String search(@RequestParam(name = "content") String content, @RequestParam(name = "type", required = false) String type, @RequestParam(name = "groupp", required = false) String groupp, @RequestParam(name = "id", defaultValue = "1") String id) {
//        String json = null;
//        List list = null;
//        int idx = Integer.valueOf(id);
//        try {
//            list = new Get().getword(content, type, groupp, idx);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        json = JSON.toJSONString(list);
//        return json;
//    }
//
//    @RequestMapping(value = "list", method = RequestMethod.GET)
//    public String list(@RequestParam(name = "country") String country, @RequestParam(name = "city") String city, @RequestParam(name = "id", defaultValue = "1") String id) {
//        String json = null;
//        List list = null;
//        int idx = Integer.valueOf(id);
//        try {
//            list = new Get().findmore(country, city, idx);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        json = JSON.toJSONString(list);
//        return json;
//    }
}
