package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.core.actions.ActionManager;

import static lippia.web.constants.SauceDemoConstants.*;

public class SauceDemoService {

    public static void navigateToSauceDemo() {
        String url = PropertyManager.getProperty("web-app.url");
        System.out.println("URL loaded from properties = " + url);
        WebActionManager.navigateTo(url);
    }

    public static void enterUsername(String username){
        ActionManager.setInput(USERNAME_INPUT, username);
    }

    public static void enterPassword(String password){
        ActionManager.setInput(PASSWORD_INPUT, password);
    }

    public static void clickLogin(){
        ActionManager.click(LOGIN_BUTTON);
    }

    public static void addBackpackToCart(){
        ActionManager.click(ADD_BACKPACK);
    }

    public static void removeBackpackFromCart(){
        ActionManager.click(REMOVE_BACKPACK);
    }

    public static String getCartBadgeText(){
        return ActionManager.getText(CART_BADGE);
    }

    public static boolean isCartBadgePresent() { return ActionManager.isPresent(CART_BADGE); }

    public static String getErrorMessage(){
        return ActionManager.getText(ERROR_MESSAGE);
    }

    public static String getProductsTitle(){
        return ActionManager.getText(PRODUCTS_TITLE);
    }
}