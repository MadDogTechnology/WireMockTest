import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.resolute.GitHubClient;

public class GitHubClientTest {
    @Rule
    GitHubClient githubclient = new GitHubClient();

    @Before
    public void setup () {
        githubclient.startServer();
    }

    @Test
    public void test () {
        githubclient.replayApiRequest();
    }
}
