package frc.robot.sparkmax;

import java.nio.channels.Pipe;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.util.sendable.SendableRegistry;

public class SparkMaxWidgetTest implements Sendable {

    double p = 0;

    public SparkMaxWidgetTest() {
        SendableRegistry.addLW(this, "SparkMaxWidget");
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        // TODO Auto-generated method stub
        builder.setSmartDashboardType("NetworkSparkMaxPIDController");
        builder.addDoubleProperty("p", this::getP, this::setP);
    }

    public double getP() {
        return p;
    }

    public void setP(double value) {
        p = value;
    }
}
