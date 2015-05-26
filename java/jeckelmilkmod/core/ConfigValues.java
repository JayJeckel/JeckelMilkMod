package jeckelmilkmod.core;

import jeckelmilkmod.common.configs.ConfigHandlerValues;
import net.minecraftforge.common.config.Configuration;

public class ConfigValues extends ConfigHandlerValues
{
	private static final long serialVersionUID = 8082068186704872032L;

	public ConfigValues()
	{
		this.add(this._updateChecking);
		this.add(this._enabledMilkBottle);
	}

	public boolean isUpdateCheckingEnabled() { return this._updateChecking.getValue(); }
	protected final ConfigValueBoolean _updateChecking = new ConfigValueBoolean("EnableUpdateChecking", Configuration.CATEGORY_GENERAL,
			"Control automatic update checking.\n.Setting this option to false will disable version checking.",
			true);

	public boolean isMilkBottleEnabled() { return this._updateChecking.getValue(); }
	protected final ConfigValueBoolean _enabledMilkBottle = new ConfigValueBoolean("EnableMilkBottle", Configuration.CATEGORY_GENERAL,
			"Enabled milk bottle item as an additional way to store milk.",
			true);

	@Override public void update(final Configuration config)
	{
		super.update(config);

		Refs.getUpdateChecker().enable(this.isUpdateCheckingEnabled());
	}
}
