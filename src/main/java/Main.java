import static spark.Spark.*;
import BimsS.*;

public class Main {
    public static void main(String[] args) {
        try {
            get("/api", "application/json", (request, response) ->{
                response.header(
                    "Access-Control-Allow-Origin",
                    "*" );

                String code = request.queryParams("code");
                System.out.println(code);
                Interpret i = new Interpret();
                String out = i.exec(code);
                System.out.println(out);
                return out;
            });
        } catch(Exception e) {
        }
    }
}
