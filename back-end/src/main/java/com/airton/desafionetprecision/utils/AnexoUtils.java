package com.airton.desafionetprecision.utils;

import com.airton.desafionetprecision.dto.ProductDTO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.postgresql.util.Base64;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class AnexoUtils {

    private static final String REGEX_BASE_64_PREFIX = "data.+base64,";
    private static final String DIRETORIO_IMAGENS = "C:\\Users\\PC show\\Documents\\PROGRAMAÇÃO\\Full Stack\\desafio-netprecision\\back-end\\src\\main\\resources\\templates\\img\\";


    public static String getMimeType(File file) throws IOException {
        return Files.probeContentType(file.toPath());
    }

    public static String toBase64(String caminho){
        File imagem = new File(DIRETORIO_IMAGENS + caminho);
        StringBuilder sbBase64 = new StringBuilder();

        try {
            String fileBase64 = java.util.Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(imagem));

            String mimeType = getMimeType(imagem);

            sbBase64.append("data:")
                    .append(mimeType)
                    .append(";base64,")
                    .append(fileBase64);

        }catch (IOException e){
            e.printStackTrace();
        }
        return sbBase64.toString();
    }

    public static String salvarImagem(ProductDTO productDTO) throws Exception {
        String nomeArquivo = productDTO.getImageName();

        if (StringUtils.isNotBlank(nomeArquivo)) {
            String nomeUnicoArquivo = UUID.randomUUID().toString() + "_" + nomeArquivo;
            String arquivoComDiretorio = FilenameUtils.normalize(DIRETORIO_IMAGENS + nomeUnicoArquivo);

            salvarAnexoBase64(arquivoComDiretorio, productDTO.getBase64());
            return nomeUnicoArquivo;
        }

        throw new IllegalArgumentException("Nome do anexo não poder vazio ou nulo.");
    }

    public static void salvarAnexoBase64(String caminho, String base64) throws Exception {
        try {
            String arquivoBase64 = base64.replaceAll(REGEX_BASE_64_PREFIX, "");
            byte[] decode = Base64.decode(arquivoBase64);
            Path path = Paths.get(caminho);
            Files.write(path, decode);

        } catch (IOException e) {
            throw e;
        }
    }



}
