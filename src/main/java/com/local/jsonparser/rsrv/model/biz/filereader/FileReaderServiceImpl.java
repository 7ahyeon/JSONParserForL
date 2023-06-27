package com.local.jsonparser.rsrv.model.biz.filereader;

public class FileReaderServiceImpl implements FileReaderService {
    private final FileReader fileReader;

    public FileReaderServiceImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public String fileRead(int select) {
        String jsonFileName = fileReader.selectService(select);
        String jsonFilePath = fileReader.getFilePath(jsonFileName);
        String jsonContent = fileReader.readFile(jsonFilePath);
        return jsonContent;
    }
}
