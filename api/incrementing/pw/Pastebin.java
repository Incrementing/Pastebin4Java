package api.incrementing.pw;

/*
 *  Powered by Pastebin (https://pastebin.com/).
 *  - Not posting to pastebin but your dev/user key is correct? Non-Pro members can only make 25 posts a day.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.*;
import java.net.*;

public class Pastebin {

    /*Editing these will do nothing as the constructor will overwrite them.*/
    protected String a = ""; //Developer Key
    protected String b = ""; //User Key
    protected String c = ""; //Paste Visibility
    protected String d = ""; //Paste Format
    protected String e = ""; //Paste Name
    protected String f = ""; //Paste Text


    /*Note: If the userKey is wrong the post will still be made but as a guest (Post still counts towards your daily post limit).*/
    public Pastebin(String devKey, String userKey, Visibility visi, String format, String name, String text) {
        String visi_str = "";
        if (visi == Visibility.PUBLIC) {
            visi_str = "0";
        }
        else if (visi == Visibility.UNLISTED) {
            visi_str = "1";
        }
        else if (visi == Visibility.PRIVATE) {
            visi_str = "2";
        }

        this.a = Utils.encode(devKey);
        this.b = Utils.encode(userKey);
        this.c = Utils.encode(visi_str);
        this.d = Utils.encode(format);
        this.e = Utils.encode(name);
        this.f = Utils.encode(text);
    }
    
    public String makePost() {
        String apiFile = "http://incrementing.pw/pastebin.php";
        String apiArgs =
                "?api_option=paste" +
                        "&api_paste_private=" + this.c +
                        "&api_paste_name=" + this.e +
                        "&api_paste_expire_date=N" /**N = Never**/ +
                        "&api_paste_format=" + this.d +
                        "&api_dev_key=" + this.a +
                        "&api_paste_code=" + this.f +
                        "&api_user_key=" + this.b;

        return Utils.sendHTTP(apiFile + apiArgs);
    }

    static class Utils {

        public static String encode(String s) {
            return URLEncoder.encode(s);
        }

        public static String sendHTTP(String s) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(s);
                connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");

                connection.setRequestProperty("Content-Language", "en-US");

                connection.setUseCaches(false);
                connection.setDoOutput(true);

                DataOutputStream wr = new DataOutputStream (
                        connection.getOutputStream());
                wr.close();

                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder();
                String line;
                while((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                return response.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                if(connection != null) {
                    connection.disconnect();
                }
            }
        }
    }

    public static enum Visibility {
        PUBLIC, UNLISTED, PRIVATE;
    }
}
