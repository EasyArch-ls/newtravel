package mybatis;

import com.alibaba.fastjson.JSON;
import mybatis.bean.Managers;
import mybatis.bean.Scenic;
import mybatis.bean.Order;
import mybatis.bean.User;
import mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Get {
    private static String conf;
    private static Reader reader;
    private static SqlSessionFactoryBuilder sfb;
    private static SqlSessionFactory sf;
    private static SqlSession session;
    private static UserMapper userMapper;
    private int all;
    private int pageSize;
    private int zcurrPage;

    public Get() throws IOException {
        conf = "mybatis-config.xml";
        reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        sfb =
                new SqlSessionFactoryBuilder();
        sf = sfb.build(reader);
        //创建Session
        session = sf.openSession();

        //调用findAll方法
        userMapper = session.getMapper(UserMapper.class);
    }


    /*
     * 分页查询
     * currPage 页数
     * pageSize 大小
     *
     * */
    public List queryScenicByArray(List list, int currPage, int pageSize) {
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = currPage * pageSize;
        if (firstIndex<=list.size()) {

        if (lastIndex > list.size()) {
            lastIndex = list.size();
        }
        return list.subList(firstIndex, lastIndex); //直接在list中截取
        }
        return new LinkedList();
}

    public List<Scenic> gettehui() {

        List<Scenic> list = userMapper.findtehui();

        return list;
    }

    public List<Scenic> getcg( String origin,String country) throws IOException {

        List<Scenic> list = userMapper.findcg(origin,country);

        return list;
    }

    public List<Scenic> getczy() throws IOException {

        List<Scenic> list = userMapper.findczy();

        return list;
    }

    public List<Scenic> getgng(String origin, String country) throws IOException {

        List<Scenic> list = userMapper.findgng(origin,country);

        return list;
    }

    public List<Scenic> getgnz() throws IOException {

        List<Scenic> list = userMapper.findgnz();

        return list;
    }

    public List<Scenic> getdd() throws IOException {

        List<Scenic> list = userMapper.finddd();

        return list;
    }

    public List allscenic(int i) {
        List<Scenic> scenic = userMapper.allscenic();
        all = scenic.size();
        pageSize = 5;
        zcurrPage = all / pageSize + 1;
        List<Scenic> scenicx = queryScenicByArray(scenic, i, pageSize);
        return scenicx;
    }

    public List[] getqgj(String origin){
        List[] listx=new List[2];
        Map map1=getgj(origin,"b","a");
        Map map2=getgj(origin,"b","b");
        Map map3=getgj(origin,"c","a");
        Map map4=getgj(origin,"c","b");
        Map map5=getgjx("a","a");
        Map map6=getgjx("a","b");
        Map map7=getgjx("b","a");
        Map map8=getgjx("b","b");
        List<Set> list=new LinkedList<>();
        List<Set> list1=new LinkedList<>();
        list.add(map1.keySet());
        list.add(map2.keySet());
        list.add(map3.keySet());
        list.add(map4.keySet());
        list1.add(map5.keySet());
        list1.add(map6.keySet());
        list1.add(map7.keySet());
        list1.add(map8.keySet());
        listx[0]=list;
        listx[1]=list1;
        return listx;
    }

    public Map getgj(String origin,String type, String groupp) {
        List<String> list = userMapper.findcfd(origin,type, groupp);
        Map map = new LinkedHashMap();
        for (String e : list) {
            map.put(e, "");

        }
        return map;
    }

    public Map getgjx(String type, String groupp) {
        List<String> list = userMapper.findcfdx(type, groupp);
        Map map = new HashMap();
        for (String e : list) {
            map.put(e, "");

        }
        return map;
    }

    public List getword(String word, String city ,int i) {
        List<Scenic> scenic = userMapper.findword(word,city);
        all = scenic.size();
        pageSize = 5;
        zcurrPage = all / pageSize + 1;
        List<Scenic> scenicx = queryScenicByArray(scenic, i, pageSize);
        return scenicx;
    }

    public String findmaneger(String name, String password) {

        Managers managers = userMapper.findmaneger(name, password);
        if (managers != null) {
            List<Order> list = userMapper.managerview();
            return (JSON.toJSONString(list, true));
        }
        return "用户名或者密码有误";
    }

    public String finduser(String name, String password) {
       User user = userMapper.finduser(name, password);
        if (user != null) {
            return "欢迎您的到来!!!~"+name;
        }
        return "用户名或者密码有误!!!";
    }

    public String registeruser(String uname,String name, String password){
        User user = userMapper.finduser(uname, password);
        if(user == null){
           boolean b= userMapper.registeruser(uname,name,password);
            System.out.println(b);
           if (b==true){
               session.commit();
               return "注册成功";
           }else {
               return "注册失败";
           }
        }
        return "用户名已存在";

    }

    public List findmore(String country,String origin,String type,String groupp,int i){
        List<Scenic> scenic = userMapper.findmore(country,origin,type,groupp);
        all = scenic.size();
        pageSize = 5;
        zcurrPage = all / pageSize + 1;
        List<Scenic> scenicx = queryScenicByArray(scenic, i, pageSize);
        return scenicx;
    }

    public boolean addorder(String name,String phone,String gender,String email,String id,String numbers,String price,String other){
        boolean b=userMapper.addorder(name,phone,gender,email,id,numbers,price,other);
        return b;
    }

    public List userview(String name,int i){
        List<Order> list=userMapper.userview(name);
        all = list.size();
        pageSize = 5;
        zcurrPage = all / pageSize + 1;
        List<Order> listx = queryScenicByArray(list, i, pageSize);
        return listx;
    }

    public List managerview(int i){
        List<Order> list=userMapper.managerview();
        System.out.println(JSON.toJSONString(list,true));
        all = list.size();
        pageSize = 5;
        zcurrPage = all / pageSize + 1;
        List<Order> listx = queryScenicByArray(list, i, pageSize);
        return listx;
    }

    public String adduser(){

        boolean b=userMapper.adduser(null,"adsd","asd");
        if (b==true) {
            session.commit();
            return ("注册成功");
        }
           return ( "注册失败");

    }

    public boolean findid(String s){
        Set set=userMapper.findid();
        return !set.contains(s);

    }

    public String addscenic(Scenic scenic){
        boolean b=false;
        Random random=new Random();
        while (true){
            int a=random.nextInt(999999999)+1000000000;
            String s="0"+a;
            if(findid(s)){
            b=userMapper.addscenic(scenic.getCountry(),scenic.getOrigin(),scenic.getPath(),scenic.getStime(),scenic.getAtprice(),scenic.getCtprice(),scenic.getUrl(),s,scenic.getType(),scenic.getGroupp(),scenic.getTitle());
            break;
            }
        }
        if (b==true) {
            session.commit();
            return ("添加成功");
        }
        return ( "添加失败");
    }

    public String xgscenic(Scenic scenic){
        boolean b=userMapper.xgscenic(scenic.getCountry(),scenic.getOrigin(),scenic.getPath(),scenic.getStime(),scenic.getAtprice(),scenic.getCtprice(),scenic.getUrl(),scenic.getId(),scenic.getType(),scenic.getGroupp(),scenic.getTitle());
        if (b==true) {
            session.commit();
            return ("修改成功");
        }
        return ( "修改失败");
    }

    public String descenic(String id){
        boolean b=userMapper.descenic(id);
        if (b==true) {
            session.commit();
            return ("删除成功");
        }
        return ( "删除失败：（id不存在）");
    }
@Test
    public String user(){
        List<Managers> managers=  userMapper.user();
        String x=JSON.toJSONString(managers, true);
        System.out.println(x);
        return x;
    }

    public String order(){
        List<Order> order=  userMapper.order();
        String x=JSON.toJSONString(order, true);
        System.out.println(x);
        return x;
    }

    public String scenic(){
        List<Scenic> scenic=  userMapper.scenic();
        String x=JSON.toJSONString(scenic, true);
        System.out.println(x);
        return x;
    }


}

