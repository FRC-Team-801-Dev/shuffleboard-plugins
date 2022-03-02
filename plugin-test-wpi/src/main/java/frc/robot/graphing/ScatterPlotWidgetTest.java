package frc.robot.graphing;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ScatterPlotWidgetTest {

    private Timer timer;
    private double[] data;
    private boolean interrupted = false;

    public ScatterPlotWidgetTest() {
        this(new double[] {1,1,-1,1,-1,-1,1,-1});
    }

    public ScatterPlotWidgetTest(double[] data) {
        this.data = new double[data.length];
        timer = new Timer();
        timer.start();

        Thread thread = new Thread(() -> {
            while(!isInterrupted()) {
                for (int i = 0; i + 1 < this.data.length; i += 2) {
                    this.data[i] = Math.cos(timer.get()) + data[i];
                    this.data[i + 1] = Math.sin(timer.get()) + data[i + 1];
                }
                SmartDashboard.putNumberArray("ScatterPlotWidgetTest", this.data);
            }
        });
        thread.start();
    }

    private boolean isInterrupted() {
        return interrupted;
    }

    public void stop() {
        interrupted = true;
    }
}
