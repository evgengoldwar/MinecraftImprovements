package MinecraftImprovements.Hud.Core.InfoLines;

import MinecraftImprovements.Hud.Core.InfoLine;

public class InfoPosition extends InfoLine {

    public InfoPosition(int order) {
        super(order);
    }

    @Override
    public String getLineString() {
        return String.format("Block: %s, %s, %s", getX(), getY(), getZ());
    }
}
