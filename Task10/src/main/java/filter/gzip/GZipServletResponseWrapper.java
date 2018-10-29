package filter.gzip;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static java.util.Objects.isNull;

public class GZipServletResponseWrapper extends HttpServletResponseWrapper implements Closeable {

    private GZipServletOutputStream gzipOutputStream = null;

    private PrintWriter printWriter = null;

    public GZipServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public void close() throws IOException {
        if (!isNull(printWriter)) {
            printWriter.close();
        }
        if (!isNull(gzipOutputStream)) {
            try {
                gzipOutputStream.close();
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    @Override
    public void flushBuffer() throws IOException {
        if (!isNull(printWriter)) {
            printWriter.flush();
        }
        if (isNull(gzipOutputStream)) {
            gzipOutputStream.flush();
        }
        super.flushBuffer();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (!isNull(printWriter)) {
            throw new IllegalStateException("gzip.error");
        }
        if (isNull(gzipOutputStream)) {
            gzipOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
        }
        return gzipOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (isNull(printWriter) && !isNull(gzipOutputStream)) {
            throw new IllegalStateException("gzip.error.print_writer");
        }
        if (isNull(printWriter)) {
            gzipOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
            printWriter = new PrintWriter(
                    new OutputStreamWriter(gzipOutputStream, getResponse().getCharacterEncoding()));
        }
        return printWriter;
    }

    @Override
    public void setContentLength(int len) {
        throw new UnsupportedOperationException("gzip.error.content_length");
    }
}