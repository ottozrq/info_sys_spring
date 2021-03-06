import com.ottozhang.ism.dao.IdentityDao;
import com.ottozhang.ism.dao.impl.IdentityDaoImpl;
import com.ottozhang.ism.dataModel.Identity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zhangruoqiu on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/appContext.xml"})

public class TestIdentityDao {
    @Inject
    IdentityDaoImpl dao;

    @Test
    public void testIdentityDao(){
        Identity identity = new Identity("ottozrq","otto", "otto", "otto");
        dao.add(identity);

        identity.setDisplayname("orrozhang");
        dao.update(identity);

        Identity iddd = new Identity();
        iddd.setEmail("otto");

        List<Identity> ids = dao.get(iddd);

        System.out.println();
        for (Identity id:ids){
            System.out.println(id.toString());
        }
        System.out.println();

        dao.delete(identity);
        ids = dao.show();

        System.out.println();
        for (Identity id:ids){
            System.out.println(id.toString());
        }
        Identity login = new Identity();
        login.setEmail("zhangxiang@gamil.com");
        login.setPassword("12321");
        ids = dao.get(login);
        if (! ids.isEmpty())
            System.out.println("login success");
        else
            System.out.println("login failed");
    }

}
