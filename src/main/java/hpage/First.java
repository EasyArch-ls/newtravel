package hpage;

import com.alibaba.fastjson.JSON;
import mybatis.Get;
import mybatis.bean.Scenic;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class First {
    private Get get;
    private List<Scenic> dd;
    private List<List<Scenic>> list4;
    /*
     * 首页
     *
     * list1表示特惠产品
     *
     * list2表示出境跟团游
     *
     * list3表示国内跟团游
     *
     * list4表示当地跟团游
     * */

    public First() throws IOException {
        get = new Get();
        dd = get.getdd();
        list4 = new LinkedList<>();
        for (int i = 0; i < 1; i++) {
            List<Scenic> l = new LinkedList<>();
            for (int j = 0; j < 4; j++) {
                l.add(dd.get(j));
            }
            list4.add(l);
        }
    }

    public String firstpage() throws IOException {
        get = new Get();
        List<Set> list = get.getqgj(null)[0];
        List<Scenic> tehui = get.gettehui();
        List<Scenic> cg = get.getcg(null, null);
        List<Scenic> gng = get.getgng(null, null);
        List listx = new LinkedList<>();
        List<List<Scenic>> list1 = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            List<Scenic> l = new LinkedList<>();
            for (int j = (i - 1) * 6; j < i * 6; j++) {
                l.add(tehui.get(j));
            }
            list1.add(l);
        }
        int count1 = 8;
        List<List<Scenic>> list2 = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            List<Scenic> l = new LinkedList<>();
            if (i == 0) {
                count1 = 6;
                for (int j = 0; j < count1; j++) {
                    l.add(cg.get(j));
                }
            } else {
                for (int j = count1; j < i * 8 + 6; j++) {
                    l.add(cg.get(j));
                    count1++;
                }

            }
            list2.add(l);
        }

        List<List<Scenic>> list3 = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            List<Scenic> l = new LinkedList<>();
            if (i == 0) {
                count1 = 6;
                for (int j = 0; j < count1; j++) {
                    l.add(gng.get(j));
                }
            } else {
                for (int j = count1; j < i * 4 + 6; j++) {
                    l.add(gng.get(j));
                    count1++;
                }
            }
            list3.add(l);
        }

        listx.add(list1);
        listx.add(list2);
        listx.add(list3);
        listx.add(list4);
        return (JSON.toJSONString(listx, true) + "~" + JSON.toJSONString(list, true));
    }


    public String firstpage(String origin) throws IOException {
        String[] ll={"东南亚","日本","中东非澳新","欧美","祖国"};
        String[] lll={"日本","澳新","亚洲","欧洲","美洲"};
        Get get = new Get();
        List<Scenic> tehui = get.gettehui();
        List[] list = get.getqgj(origin);
        List<Set>listq=list[0];
        System.out.println(listq.get(0).size());
        List<Set>listw=list[1];
        List listx = new LinkedList<>();
        List<List<Scenic>> list1 = new LinkedList<>();
        List<List<Scenic>> list2 = new LinkedList<>();
        Iterator<String> value = listq.get(0).iterator();
        for (int i = 1; i < 6; i++) {
            List<Scenic> l = new LinkedList<>();
            for (int j = 0; j <tehui.size() ; j++) {
                if(tehui.get(j).getCountry().equals(ll[i-1])){
                    l.add(tehui.get(j));
                }
            }
            list1.add(l);
        }
        int i=0;
        while (value.hasNext()) {
          String country="";
            if(origin.equals("北京")){
                if(i==5){
                    break;
                }
            country=lll[i];
            }else {
                country = value.next();
            }
           // country = value.next();
            System.out.println(country+"-------------------------------------");
            List<Scenic> cg = get.getcg(origin, country);
            list2.add(cg);
            i++;
        }
        System.out.println();
        System.out.println(i);
        System.out.println();
        List<List<Scenic>> list3 = new LinkedList<>();
        Iterator<String> valuex = listq.get(2).iterator();
        while (valuex.hasNext()) {
            String country = valuex.next();
            System.out.println(country);
            List<Scenic> gng = get.getgng(origin, country);
            list3.add(gng);
        }
        listx.add(list1);
        listx.add(list2);
        listx.add(list3);
        listx.add(list4);
        return (JSON.toJSONString(listx, true) + "~" + JSON.toJSONString(listw, true));
    }

    public static void main(String[] args) {
        try {
           // System.out.println(new First().firstpage("北京"));
            new First().firstpage("北京");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
