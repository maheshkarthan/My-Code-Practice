package zTest;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class ChecksumTest {

    public static void main(String[] args) {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("Date:: " + date);
        //String transactionId = TransactionID.getTransactionId();
        String merchantUniqueId = String.valueOf(UUID.randomUUID());
        System.out.println("Date:: " + merchantUniqueId);

        String submitRequest =
                "8349311055113668617" 
                + "168023" 
                + "bz_paypalgermanyuser7" 
                + "18659908" 
                + "bz_paypalgermanyuser7@ivycomptech.com" 
                + "10.55" 
                + "CAD"
                + "15716584162391436" 
                + merchantUniqueId 
                + date 
                + "gJRIrFUwqV8CC0uPzX21V54pHm20RtXJpNa9yi3GXJayLlZpCsq0QFs3lNJdeVbp";
        
        String newUserRegistration = "8349311055113668617"
                +"168023"
                +"bz_qiwikzuser2"
                +"100111"
                +"KZ"
                +"en_UK"
                +"20191004114421"
                + "gJRIrFUwqV8CC0uPzX21V54pHm20RtXJpNa9yi3GXJayLlZpCsq0QFs3lNJdeVbp";
        
        String approvalRequest = "8349311055113668617" 
                + "168023" 
                + "4689648" 
                + "54629183" 
                + "20191203053421"
                + "gJRIrFUwqV8CC0uPzX21V54pHm20RtXJpNa9yi3GXJayLlZpCsq0QFs3lNJdeVbp";
                
        System.out.println("Approval Request:: "+ DigestUtils.sha256Hex(approvalRequest));
        
        System.out.println("New::   "+DigestUtils.sha256Hex(newUserRegistration));

        System.out.println("TransactionId:" +  " submit checksum:" + (DigestUtils.sha256Hex(submitRequest)));

        int name = '’';
        System.out.println("Name: "+name);
        
        int arr[] ={1217263, 1217291, 1217694, 1223921, 1227027, 1227651, 1227754, 1230309,1210771, 1217218, 1217405, 1229117,1205765, 1211887};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {            
            System.out.print(arr[i]+",");
        }
    } 
}
