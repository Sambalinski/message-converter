import java.util.Base64;
import java.util.Scanner;

/**
 * Author @Sambalinski
 * Кодирует и раскодировывает сообщения в формате Base64
 */
public class MessageConverter {
    public static void main(String... args) {
        System.out.println("Инструкция: \nДля кодирования сообщения перед сообщением поставьте флаг \"--\". \nДля раскодирования сообщения просто вставьте эту непонятную хуйню и нажмите enter");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String message = scanner.nextLine();
            if (message.startsWith("--")) {
                System.out.println(getEncodeString(message.substring(2)));
            } else System.out.println(getDecodeString(message));
        }
        
    }
    
    private static String getEncodeString(String message) {
        byte[] bytes = Base64.getEncoder().encode(message.getBytes());
        return new String(bytes);
    }
    
    
    private static String getDecodeString(String encodedMessage) {
        try {
            byte[] decode = Base64.getDecoder().decode(encodedMessage.getBytes());
            return new String(decode);
        } catch (IllegalArgumentException e) {
            return "Еблан, для кодирования сообщения ты забыл поставить флаг \"--\"";
        }
        
    }
}
