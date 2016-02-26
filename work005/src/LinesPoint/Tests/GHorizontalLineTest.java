package LinesPoint.Tests;

import LinesPoint.Client.Client;
import LinesPoint.Client.GComponents.GHorizontalLine;
import LinesPoint.Client.Game;
import LinesPoint.Client.LinesAndPoints;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 24.02.16.
 */
public class GHorizontalLineTest {

    @Test
    public void horizontalLineShouldHaveCorrectPositionInGrid() {
        GHorizontalLine line = new GHorizontalLine(1, 2);

        Assert.assertTrue(line.gridX == 0 && line.gridY == 1);
    }

    @Ignore
    @Test
    public void horizontalLineShouldBeSelectedIfClicked() throws IOException, ClassNotFoundException {
        Client client = mock(Client.class);
        client.linesAndPoints = mock(LinesAndPoints.class);
        client.os = mock(ObjectOutputStream.class);
        client.is = mock(ObjectInputStream.class);
        client.socket = mock(Socket.class);

        client.game = mock(Game.class);
        GHorizontalLine line = new GHorizontalLine(1, 2);
        line.mouseClick();
        Assert.assertTrue(line.isSelected);

    }

}
