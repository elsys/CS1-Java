package src;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import StudentCode.*;
import static student.Translations.Translator._;
import java.text.MessageFormat;

/**
 * @author ogoletti
 * @version 30/11/16
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Etudiant.class)
public class VectorTestMock {

    public static final String FILENAME = "file.txt";
    String msgError = _("génère une IOException");
    String msgException = _("Lors de l''exécution de votre méthode loadVector avec un fichier qui {0}, votre méthode a lancé une exception ");
    String msgNull =  _("Lors de l''exécution de votre méthode loadVector avec un fichier qui {0}, votre méthode a retourné le tableau {1} alors que le résultat attendu est null. ");
    @Test
    public void testLoadVectorIOExceptionInReadLine() {

        try {
            //You can mock concrete classes, not just interfaces
            FileReader mockedFR = mock(FileReader.class);

            BufferedReader mockedBR = mock(BufferedReader.class);
            when(mockedBR.readLine()).thenThrow(new IOException());

            //stubbing
            PowerMockito.whenNew(FileReader.class).withArguments(FILENAME).thenReturn(mockedFR);
            PowerMockito.whenNew(BufferedReader.class).withArguments(mockedFR).thenReturn(mockedBR);

            String msg, msge;
            double[] r = {};


            msge = MessageFormat.format(msgException, msgError);
            try {
                r = Etudiant.loadVector(FILENAME);
            } catch (Exception e) {
                fail(msge + e.toString() + " : " + e.getMessage());
            }
            msg = MessageFormat.format(msgNull, msgError, Arrays.toString(r));
            assertNull(msg, r);

            try {
                verify(mockedBR, times(1)).close();
            } catch (MockitoAssertionError e) {
                throw new AssertionError(_("Lors de l'exécution de votre méthode loadVector avec une IOException lancée par le readLine() du BufferedReader, le fichier n'a pas été fermé correctement."), e);
            }
        } catch (Exception e) {
        }
    }

    @Test
    public void testLoadVectorIOExceptionInCtor() {
        try {
            //stubbing
            PowerMockito.whenNew(FileReader.class).withArguments(FILENAME).thenThrow(new IOException());

            String msg, msge;
            double[] r = {};

            msge = MessageFormat.format(msgException, msgError);
            try {
                r = Etudiant.loadVector(FILENAME);
            } catch (Exception e) {
                fail(msge + e.toString() + " : " + e.getMessage());
            }
            msg = MessageFormat.format(msgNull, msgError, Arrays.toString(r) );
            assertNull(msg, r);

        } catch (Exception e) {
        }
    }


    @Test
    public void testLoadVectorIOExceptionInClose() {
        try {
            //You can mock concrete classes, not just interfaces
            FileReader mockedFR = mock(FileReader.class);

            BufferedReader mockedBR = mock(BufferedReader.class);
            doThrow(new IOException()).when(mockedBR).close();

            //stubbing
            PowerMockito.whenNew(FileReader.class).withArguments(FILENAME).thenReturn(mockedFR);
            PowerMockito.whenNew(BufferedReader.class).withArguments(mockedFR).thenReturn(mockedBR);

            String msg, msge;
            double[] r = {};

            msge = MessageFormat.format(msgException, msgError);
            try {
                r = Etudiant.loadVector(FILENAME);
            } catch (Exception e) {
                fail(msge + e.toString() + " : " + e.getMessage());
            }
            msg = MessageFormat.format(msgNull, msgError, Arrays.toString(r) );
            assertNull(msg, r);
        } catch (Exception e) {
        }
    }


    @Test
    public void testLoadVectorUnknownFile() {
        try {
            String msg, msge;
            double[] r = {};

            String msgErrorExist = _("n''existe pas");
            msge = MessageFormat.format(msgException, msgErrorExist);
            try {
                r = Etudiant.loadVector(FILENAME);
            } catch (Exception e) {
                fail(msge + e.toString());
            }
            msg = MessageFormat.format(msgNull, msgErrorExist, Arrays.toString(r) );
            assertNull(msg, r);
        } catch (Exception e) {
        }
    }


}
