package mybatis.mapper;

import mybatis.bean.Managers;
import mybatis.bean.Order;
import mybatis.bean.Scenic;
import mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserMapper {

    public List<Scenic> findtehui();

    public List<Scenic> findcg(@Param("origin") String origin, @Param("country") String country);

    public List<Scenic> findczy();

    public List<Scenic> findgng(@Param("origin") String origin, @Param("country") String country);

    public List<Scenic> findgnz();

    public List<Scenic> finddd();

    public List<Scenic> findfirst(@Param("origin") String origin);

    public List<Scenic> findmore(@Param("country") String country, @Param("origin") String origin,@Param("type") String type,@Param("groupp") String groupp);

    public List<String> findcfd(@Param("origin") String origin, @Param("type") String type, @Param("groupp") String groupp);

    public List<String> findcfdx(@Param("type") String type, @Param("groupp") String groupp);

    public Set findid();

    public List<Scenic> findword(@Param("word") String word, @Param("origin") String origin);

    public Managers findmaneger(@Param("name") String name, @Param("password") String password);

    public User finduser(@Param("uname") String uname, @Param("password") String password);

    public boolean registeruser(@Param("uname") String uname, @Param("name") String name, @Param("password") String password);

    List<Order> userview(@Param("name") String name);

    public boolean addorder(@Param("name") String name, @Param("phone") String phone, @Param("gender") String gender, @Param("email") String email, @Param("id") String id, @Param("numbers") String numbers, @Param("price") String price, @Param("other") String other);

    List<Order> managerview();

    public List<Scenic> allscenic();

    public boolean xgscenic(@Param("country") String country, @Param("origin") String origin, @Param("path") String path, @Param("stime") String stime, @Param("atprice") String atprice, @Param("ctprice") String ctprice, @Param("url") String url, @Param("id") String id, @Param("type") String type, @Param("groupp") String groupp, @Param("title") String title);

    public boolean addscenic(@Param("country") String country, @Param("origin") String origin, @Param("path") String path, @Param("stime") String stime, @Param("atprice") String atprice, @Param("ctprice") String ctprice, @Param("url") String url, @Param("id") String id, @Param("type") String type, @Param("groupp") String groupp, @Param("title") String title);

    boolean descenic(@Param("id") String id);



    boolean adduser(@Param("uname") String uname, @Param("name") String name, @Param("password") String password);
    List<Managers> user();
    List<Order> order();
    List<Scenic> scenic();

//     Scenic selectByaccount(String account);
//    int insert(Scenic scenic);
//    int updateByphonenumber(@Param("phonenumber") String phonenumber, @Param("id") Integer id);
//    int updateBygithubid(@Param("githubid") Integer githubid, @Param("id") Integer id);
}
