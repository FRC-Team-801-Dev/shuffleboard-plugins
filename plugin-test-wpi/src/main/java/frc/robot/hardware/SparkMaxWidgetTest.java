package frc.robot.hardware;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SparkMaxWidgetTest implements Sendable {

    double p = 0;

    public SparkMaxWidgetTest() {
        SmartDashboard.putData("SparkMaxWidgetTest", this);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("SparkMax");
        builder.addDoubleProperty("p_0", this::getP, this::setP);
    }

    public double getP() {
        return p;
    }

    public void setP(double value) {
        p = value;
    }
}
