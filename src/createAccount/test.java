package createAccount;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.ArrayList;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Size;
import org.opencv.core.Core;
import org.opencv.face.LBPHFaceRecognizer;
import static org.opencv.core.CvType.CV_32SC1;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.COLOR_BGRA2GRAY;

public class test {
    
    /**
     * This method reads the images that are saved in the folder, retrieves the
     * ID of each photo and generates the "trainer" for the LBPH algorithm.
     */
    
    public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File rootDir = new File("C:\\Users\\Cristi\\Desktop\\imagini");
        
        File[] directories = rootDir.listFiles((File current, String name) -> new File(current, name).isDirectory());
        FilenameFilter filter = (File dir, String name) -> ( name.endsWith(".jpg") || name.endsWith(".png"));
        
        int numberOfFiles = 0, index = 0;     
        for (File directory : directories) 
            numberOfFiles = numberOfFiles + directory.listFiles(filter).length;
    
        File[] files = new File[numberOfFiles];
        
        for (File directory : directories) {
            File aux;
            File[] dirfiles = directory.listFiles(filter);
            
            for (int i = 0; i < dirfiles.length - 1; i++) 
                for (int j = 0; j < dirfiles.length; j++) 
                    if (Integer.parseInt(dirfiles[i].getName().split("\\.")[1]) < Integer.parseInt(dirfiles[j].getName().split("\\.")[1])) {
                        aux = dirfiles[i];
                        dirfiles[i] = dirfiles[j];
                        dirfiles[j] = aux;
                    }
            
            System.arraycopy(dirfiles, 0, files, index, dirfiles.length);
            index = index + dirfiles.length;
        }
       
       List<Mat> photos = new ArrayList<>();
        Mat labels = new Mat(files.length, 1, CV_32SC1);

        int counter = 0;
        for (File image : files) {
            Mat photo = imread(image.getAbsolutePath(), COLOR_BGRA2GRAY);
            int idP = Integer.parseInt(image.getName().split("\\.")[1]);
            Imgproc.resize(photo, photo, new Size(160, 160));

            photos.add(counter, photo);
            labels.put(counter, 0, idP);
            counter++;
        }
        LBPHFaceRecognizer lbph = LBPHFaceRecognizer.create(1, 8, 8, 8, 12);
        lbph.train(photos, labels);
        lbph.save("C:\\Users\\Cristi\\Desktop\\imagini\\classifierLBPH.yml");
    }

}
