package com.joellobo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.utils.IOUtils;

public class FileUtils2 {
	
    private static Logger logger = new Logger();

	
    /**
     * Descompacta um arquivo.
     * @param origem Arquivo compactado
     * @param destino Arquivo descompactado
     */
    public static void descompactar(final String origem, final String destino) {
        Cronometro cronometroTotal = null;
        Cronometro cronometro = null;

        cronometroTotal = new Cronometro();
        cronometroTotal.iniciar();

        Path zipFile = Paths.get(origem);
        Path decryptTo = Paths.get(destino);

        try {
            Files.createDirectories(decryptTo);
        } catch (IOException e1) {
            logger.log("");
        }


        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry entry;
            OutputStream outputStream;

            while ((entry = zipInputStream.getNextEntry()) != null) {
                cronometro = new Cronometro();
                cronometro.iniciar();

                final Path toPath = decryptTo.resolve(entry.getName());
                outputStream = new FileOutputStream(toPath.toFile());
                IOUtils.copy(zipInputStream, outputStream);

                cronometro.finalizar();

                logger.log(CLog.CARGA_DATAPREV + "tempo para extrair o arquivo " + toPath + ": "
                    + cronometro.getTempo());
            }
        } catch (IOException e) {
            logger.log("");
        }

        cronometroTotal.finalizar();

        logger.log(CLog.CARGA_DATAPREV + "tempo total para descompactar o zip " + zipFile + ": "
            + cronometroTotal.getTempo());
    }

}
