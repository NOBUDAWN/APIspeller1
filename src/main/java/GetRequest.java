import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {
    static String url = "https://speller.yandex.net/services/spellservice";


    public static void main(String[] args) {
        CloseableHttpResponse response = null;

        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url+"/checkText?text=Смишная+сава+абитает+в+хустых+лесах+.Она+декая+но+красевая+.");
            response = httpclient.execute(httpGet);

            System.out.println(EntityUtils.toString(response.getEntity()));

        } catch (IOException e) {
            System.out.println("Произошла ошибка. Повторите запрос.");
        }
        finally {
            try {
                response.close();
            } catch (NullPointerException n) {
                n.printStackTrace();

            } catch (IOException e) {
                System.out.println("Произошла ошибка");
            }
        }

    }
}
