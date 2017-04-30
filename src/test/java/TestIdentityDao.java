import com.ottozhang.ism.dao.IdentityDao;
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
    IdentityDao dao;

    @Test
    public void testIdentityDao(){
        Identity identity = new Identity("ottozrq","otto", "otto", "otto");
        dao.add(identity);

        identity.setDisplayname("orrozhang");
        dao.update(identity);

        List<Identity> ids = dao.show();

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
    }

}
