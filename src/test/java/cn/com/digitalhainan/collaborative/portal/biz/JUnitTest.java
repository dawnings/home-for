package cn.com.digitalhainan.collaborative.portal.biz;

import cn.com.digitalhainan.collaborative.standard.base.services.idaas.dto.IDaaSBindAccountDTO;
import cn.com.digitalhainan.collaborative.standard.base.services.idaas.dto.IDaaSRespDTO;
import cn.com.digitalhainan.collaborative.standard.base.services.idaas.manager.IDaaSManager;
import cn.com.digitalhainan.collaborative.standard.base.services.yunshu.dto.YunShuPage;
import cn.com.digitalhainan.collaborative.standard.base.services.yunshu.dto.YunShuResponseResult;
import cn.com.digitalhainan.collaborative.standard.base.services.yunshu.dto.YunShuWorkItemDTO;
import cn.com.digitalhainan.collaborative.standard.base.services.yunshu.manager.YunShuManager;
import cn.com.digitalhainan.collaborative.standard.base.services.yunshu.vo.FinishWorkItemsVO;
import cn.com.digitalhainan.collaborative.standard.base.services.yunshu.vo.WorkItemsVO;
import cn.com.digitalhainan.collaborative.standard.biz.enums.SsoGenerateEnum;
import cn.com.digitalhainan.collaborative.standard.biz.sso.SsoContext;
import cn.dawnings.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class JUnitTest {

    @Resource
    private SsoContext ssoContext;
    @Resource
    private YunShuManager yunShuManager;
    @Resource
    private IDaaSManager iDaaSManager;

    @Test
    public void sso() {
        String url = ssoContext.getUrl(SsoGenerateEnum.DOUBLE_RANDOM);
    }

    @Test
    public void idaas() {
        IDaaSRespDTO<IDaaSBindAccountDTO> result = iDaaSManager.bindDingDingAccount(
                "GE_e5c0c89b7d2340cd9287f895acb75317",
                "13533694725");
    }

    @Test
    public void getToken() {
//        System.out.print("aaaa");
        String token = yunShuManager.getToken();
    }

    @Test
    public void searchWorkitems() {
        WorkItemsVO vo = new WorkItemsVO().setAccount("admin").setAppCode("");
        YunShuResponseResult<YunShuPage<YunShuWorkItemDTO>> rs = yunShuManager.searchWorkitems(vo);
    }

    @Test
    public void searchFinishedWorkitems() {
        FinishWorkItemsVO vo = new FinishWorkItemsVO().setAccount("admin").setAppCode("");
        YunShuResponseResult<YunShuPage<YunShuWorkItemDTO>> rs = yunShuManager.searchFinishedWorkitems(vo);
    }

    @Test
    public void queryWorkItemsPage() {
//        CasePageVO vo = new CasePageVO().setStatus(0);
//        BaseBizResponse<Page<CaseDO>> rs =  tBCaseManager.queryWorkItemsPage(vo);
//        System.out.print(JsonUtils.obj2JsonStr(rs));
    }

}
