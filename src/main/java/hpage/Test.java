package hpage;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Security;
import mybatis.Get;
import mybatis.bean.Scenic;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Liyihe
 * @Date 19-3-13 下午4:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Get get = new Get();
      //  List<Scenic> word=get.getword("本",null,null,1);
        //List<Scenic> word1=get.getword("本",2);

       // List<Set> list=get.getqgj(null);

 /*       Get get = new Get();
        List<Scenic> tehui = get.gettehui();
        List<Scenic> cg = get.getcg();
        List<Scenic> czy = get.getczy();
        List<Scenic> gng=get.getgng();
        List<Scenic> gnz=get.getgnz();
        List<Scenic> dd=get.getdd();
        List<Scenic> word=get.getword("本");
        List list = new LinkedList<>();
        List all = get.getall();
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
                for (int j = count1; j < i* 8 + 6; j++) {
                    l.add(cg.get(j));
                    count1++;
                }

            }
            list2.add(l);
        }

        List<List<Scenic>> list3=new LinkedList<>();
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

        List<List<Scenic>> list4=new LinkedList<>();
        for (int i = 0; i <1 ; i++) {
            List<Scenic> l=new LinkedList<>();
            for (int j = 0; j < 4; j++) {
                l.add(dd.get(j));
            }
            list4.add(l);
        }
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(JSON.toJSONString(list, true));*/
       // System.out.println(JSON.toJSONString(word, true)+"~"+JSON.toJSONString(list, true));
    }


}
