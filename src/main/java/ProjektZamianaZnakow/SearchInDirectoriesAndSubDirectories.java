package ProjektZamianaZnakow;



import java.io.File;

public class SearchInDirectoriesAndSubDirectories {





    public void listFilesAndFilesSubDirectories(String directoryName) {


        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        assert fList != null;
        for (File file : fList) {


            try {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());

                }

                else if (file.isDirectory() && file.isDirectory()) {
                    listFilesAndFilesSubDirectories(file.getAbsolutePath());
                }


            } catch (NullPointerException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        SearchInDirectoriesAndSubDirectories listFilesUtil = new SearchInDirectoriesAndSubDirectories();
        final String directory = "C:\\";
        listFilesUtil.listFilesAndFilesSubDirectories(directory);
    }
}