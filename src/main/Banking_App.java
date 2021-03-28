package main;

import createAccount.Create;
import createAccount.Errors;
import loginForm.Login;
import loginForm.RecoveryForm;
import loginForm.ChangePasswordForm;
import mainFrame.Frame;
import mainFrame.AdminFrame;
import mainFrame.Transactions;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import mainFrame.AddClientForm;
import mainFrame.CreditScoreForm;
import mainFrame.LoanApplicationForm;
import org.json.JSONException;
import org.opencv.core.Core;
/**
 *
 * @author Cristi
 */
public class Banking_App {
    
    
    public static void main(String[] args) throws IOException,ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, JSONException{
        
       System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
       
       UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

       Start start = new Start();
       Create create = new Create();
       Errors errors = new Errors();
       Login log = new Login();
       RecoveryForm recovery = new RecoveryForm();
       ChangePasswordForm form = new ChangePasswordForm();
       Frame frame = new Frame();
       AddClientForm ClientForm = new AddClientForm(); 
       LoanApplicationForm loanForm = new LoanApplicationForm();
       CreditScoreForm scoreForm = new CreditScoreForm();
       AdminFrame admframe = new AdminFrame();
       Transactions trans = new Transactions();

       //legatura intre obiecte
       start.setClass(create,log);
       create.setClass(start, errors);
       errors.setClass(create);
       log.setFrame(start,recovery, frame,admframe);
       recovery.setLogin(log, form);
       form.setFrame(recovery);
       frame.setLoginTransForms(log, trans, ClientForm, loanForm);
       loanForm.setFrame(frame, scoreForm);
       scoreForm.setClass(loanForm);
       ClientForm.setFrame(frame);
       admframe.setLoginClass(log);
       trans.setFrame(frame);
       
       //fereastra de start visibila
       start.setVisible(true);
       

    }


}
