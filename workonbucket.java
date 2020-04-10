import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class workonbucket {
    public static void main(String[] args)throws Exception {
        createbucket();
    }
    
 public static void createbucket() throws Exception {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);
        AmazonS3Client s3Client = new AmazonS3Client(awsCreds);
        String newBucketName = "stevenbucket01";
        s3Client.createBucket(newBucketName);
        final String fileName = "randomtext.txt";
        File file = new File(S3JavaSDKExample.class.getResource(fileName).toURI());
        {
            PutObjectRequest putRequest1 = new PutObjectRequest(newBucketName, "unencrypted/" + fileName + "." + System.currentTimeMillis(), file);
            PutObjectResult response1 = s3Client.putObject(putRequest1);
            System.out.println("Uploaded object encryption status is " +
                    response1.getSSEAlgorithm());
        }
    }
}
