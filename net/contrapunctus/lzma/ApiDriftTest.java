package net.contrapunctus.lzma;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A very simple set of tests to detect API drift over time.
 * Essentially, we just access all the public classes, methods, and
 * fields and check their types.  Then, any changes that affect the
 * API should cause a compilation error or test failure.
 */
public class ApiDriftTest
{
    /**
     * Access the public API of the {@link Version} class.
     */
    @Test public void versionAPI()
    {
        int x = Version.major;
        int y = Version.minor;
        String s = Version.context;
        Version.main(new String[0]);
        Version.main(new String[1]);
        Version v = new Version(); // pointless but brings line coverage to 100%
    }

    /**
     * Access the public API of the {@link LzmaOutputStream} class.
     */
    @Test public void outstreamAPI()
    {
        LzmaOutputStream.LZMA_HEADER = false;
        LzmaOutputStream los;
        los = new LzmaOutputStream(new ByteArrayOutputStream());
        los = new LzmaOutputStream(new ByteArrayOutputStream(), 8, 2);
        assertTrue(los instanceof OutputStream);
    }

    /**
     * Access the public API of the {@link LzmaInputStream} class.
     */
    @Test public void instreamAPI()
    {
        LzmaInputStream lis;
        lis = new LzmaInputStream(new ByteArrayInputStream(new byte[0]));
        assertTrue(lis instanceof InputStream);
    }
}
