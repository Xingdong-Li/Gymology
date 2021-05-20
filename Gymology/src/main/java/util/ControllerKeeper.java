package util;

import controller.AccountController;
import controller.HomeController;
import controller.LoginController;
import controller.RegisterController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author Dong
 */
public final class ControllerKeeper {
    private static final HashMap<Class<?>,Object> CONTROLLER_BOX =new HashMap<>();

    public static <T> void put(Class<? extends Initializable> clazz, T controller){
        if (clazz!=controller.getClass()) {
            throw new RuntimeException("Not the same class!");
        }
        CONTROLLER_BOX.put(clazz,Objects.requireNonNull(controller));
    }

    public static <T> T get(Class<T> clazz){
        T controller =(T)CONTROLLER_BOX.get(clazz);
        return Objects.requireNonNull(controller);
    }

    public static <T> void reload(Class<T> clazz) throws IOException {
        FXMLLoader loader;
        if (clazz == AccountController.class){
            loader = new FXMLLoader(AccountController.class.getResource("/fxml/account.fxml"));
            Parent parent = loader.load();
            AccountController controller = loader.getController();
            controller.setScene(parent);
            put(AccountController.class,controller);
        }else if (clazz == HomeController.class){
            loader = new FXMLLoader(HomeController.class.getResource("/fxml/home.fxml"));
            Parent parent = loader.load();
            HomeController controller = loader.getController();
            controller.setScene(parent);
            put(HomeController.class,controller);
        }else if (clazz == LoginController.class){
            loader = new FXMLLoader(LoginController.class.getResource("/fxml/login.fxml"));
            Parent parent = loader.load();
            LoginController controller = loader.getController();
            controller.setScene(parent);
            put(LoginController.class,controller);
        }else if (clazz == RegisterController.class){
            loader = new FXMLLoader(RegisterController.class.getResource("/fxml/register.fxml"));
            Parent parent = loader.load();
            RegisterController controller = loader.getController();
            controller.setScene(parent);
            put(RegisterController.class,controller);
        }
    }

}
