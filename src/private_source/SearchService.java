package private_source;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchService {
    public static void main(String[] args) throws Exception {

        SearchService service = new SearchService();

        String filePath = "C:/temp";
        String[] dricNm = service.bizGbn(new File(filePath));

        File newFile = service.createFile();

        for (String bizNm : dricNm){
            String newFilePath = filePath + "/" + bizNm + "/biz";
            service.readFile(newFilePath, newFile);
        }

    }
    /**
     * 경로가 디렉토리일경우 배열로 반환한다
     * 
     * */
    public String[] bizGbn(File file){
        //file.list() 메서드 안에 FilenameFilter.accept를 호출하는 로직이 있다
        //필요한것은 FilenameFilter 자체를 구현하기만 하면 된다 -
        //(current, name) - 인터페이스.accept() 파라미터값 표시 - 익명 클래스를 람다식 으로 변환하면 파라미터만 남는다
        // -> 인터페이스 구현 - 가져올 파일 조건

        String [] direc = file.list((current, name) -> new File(current,name).isDirectory());
        return direc;
    }
    /**
     * 디렉토리 안의 파일을 가져온다
     * -> 메서드 readClass 로 원하는 내용을 읽은뒤 만들어진 파일에 write 한다 
     * */
    public void readFile(String filePath, File newFile) throws Exception{
        File file = new File(filePath);
        file.setReadable(true);
        File[] files = file.listFiles();
        List<File> listFiles = Arrays.asList(files);

        List<BufferedReader> bufferedReaders = new ArrayList<>();
        String result = "";
        String code = "";
        String fileName = "";
        for (File f : listFiles) {
            f.setReadable(true);
            fileName = f.getName();

            System.out.println("*********" + fileName + "**************" );
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

            code = fileName.substring(0,fileName.indexOf("Biz"));
            result = readClass(bufferedReader, code);

            FileOutputStream fos = new FileOutputStream(newFile, true);
            fos.write(result.getBytes());
            System.out.println("****************" + fileName + "끝*******");
        }
    }
    /**
     * 디렉토리 안의 파일을 읽어 원하는 결과 string을 모아 리턴한다
     * 현재
     * 화면번호 \t 거래코드 \t 거래코드
     * // 주석처리된 라인은 그대로 호출
     * */
    private String readClass(BufferedReader bufferedReader, String code) throws IOException {
        String line;
        String findRequestCode = "trxCd =";
        String findResponseCode = "response.getData";

        String result = "";

        while ((line = bufferedReader.readLine()) != null){
            if(line.contains(findRequestCode)){
                if(!line.contains("//")){
                    line = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));

                }
                result += code + "\t" + line + "\t";
            }
            if(line.contains(findResponseCode)){
                if(!line.contains("//")){
                    line = "ONB" + line.substring(line.indexOf("(") + 1, line.lastIndexOf(")") -9);

                }
                result +=  line + "\n";
            }

        }
        System.out.println("result = " + result);
        return result;
    }
    /**
     * return된 string을 write 하기위해 새로운 파일을 생성한다
     * */
    public File createFile(){
        //저장할 디렉토리
        File file = new File ("C://");
        return file;
    }
}
