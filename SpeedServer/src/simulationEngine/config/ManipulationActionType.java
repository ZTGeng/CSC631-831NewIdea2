/**
 * 
 */
package simulationEngine.config;

/**
 * @author Sonal
 *
 */
public enum ManipulationActionType
{
	SPECIES_REMOVAL(0), 
	SPECIES_INVASION(1), 
	SPECIES_EXPLOIT(2), 
	SPECIES_PROLIFERATION(3),
        MULTIPLE_BIOMASS_UPDATE(4);

	private final int typeIndex;

	private ManipulationActionType(int typeIndex)
	{
		this.typeIndex = typeIndex;
	}

	public int getManipulationActionType()
	{
		return typeIndex;
	}	
}
