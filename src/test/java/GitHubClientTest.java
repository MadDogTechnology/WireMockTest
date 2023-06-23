import org.junit.Before;
import org.junit.Test;

import com.resolute.GitHubClient;

public class GitHubClientTest {
    
    GitHubClient githubclient = new GitHubClient();

    // Tests whether WireMock server starts up without issues
    @Before
    public void setup () {
        githubclient.startServer();
    }

    // Tests whether methods of githubclient object perform without compiling errors
    @Test
    public void test () {
        githubclient.replayApiRequest();
    }

    // Will continue to work on tests to see if methods are performing as expected
}
