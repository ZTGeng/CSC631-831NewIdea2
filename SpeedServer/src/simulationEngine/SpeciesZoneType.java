package simulationEngine;

import java.util.List;

import model.SpeciesType;

/**
 * @author Sonal
 *
 */
public class SpeciesZoneType {

    public enum action {
        NEW, ADDED, REDUCE, EXTINCT, NO_ACTION
    };

    public enum SpeciesTypeEnum {
        ANIMAL, PLANT, UNKNOWN
    };

    private String name;
    private int nodeIndex;
    private List<Integer> lPreyIndex;
    private List<Integer> lPredatorIndex;
    private List<SpeciesType> lPrey;
    private List<SpeciesType> lPredator;
    private int speciesCount;
    private double perSpeciesBiomass;
    private double currentBiomass;
    private SpeciesTypeEnum type;
    private double trophicLevel;
    private boolean biomassUpdated = false;

    private double paramK = -1;  // carrying capacity (plants only)
    private double paramR = -1;  // growth rate (plants only)
    private double paramX = -1;  // metabolic rate      
    // parameter k, r, x can't have negative value. if they have negative value, it means that data is not assigned yet.
    private List<ParamValue> paramE;  // assimilation efficiency (animal only)
    private List<ParamValue> paramD;  // predator interference (animal only)     
    private List<ParamValue> paramQ;  // functional response control parameter (animal only)      
    private List<ParamValue> paramA;  // relative half saturation density (animal only)


 
    
    
    
    /**
     * @param name
     * @param nodeIndex
     * @param speciesCount
     * @param perSpeciesBiomass
     * @param currentBiomass
     * @param type
     */
    public SpeciesZoneType(String name, int nodeIndex, int speciesCount,
            double perSpeciesBiomass, double currentBiomass,
            SpeciesTypeEnum type) {
        super();
        this.name = name;
        this.nodeIndex = nodeIndex;
        this.speciesCount = speciesCount;
        this.perSpeciesBiomass = perSpeciesBiomass;
        this.currentBiomass = currentBiomass;
        this.type = type;
    }

    /**
     * @param name
     * @param nodeIndex
     * @param lPreyIndex
     * @param lPredatorIndex
     * @param lPrey
     * @param lPredator
     * @param speciesCount
     * @param perSpeciesBiomass
     * @param currentBiomass
     * @param type
     */
    public SpeciesZoneType(String name, int nodeIndex,
            List<Integer> lPreyIndex, List<Integer> lPredatorIndex,
            List<SpeciesType> lPrey, List<SpeciesType> lPredator,
            int speciesCount, double perSpeciesBiomass, double currentBiomass, SpeciesTypeEnum type) {
        super();
        this.name = name;
        this.nodeIndex = nodeIndex;
        this.lPreyIndex = lPreyIndex;
        this.lPredatorIndex = lPredatorIndex;
        this.lPrey = lPrey;
        this.lPredator = lPredator;
        this.speciesCount = speciesCount;
        this.perSpeciesBiomass = perSpeciesBiomass;
        this.currentBiomass = currentBiomass;
        this.type = type;
    }

    /**
     * 
     */
    public SpeciesZoneType() {
        super();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nodeIndex
     */
    public int getNodeIndex() {
        return nodeIndex;
    }

    /**
     * @param nodeIndex the nodeIndex to set
     */
    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    /**
     * @return the lPreyIndex
     */
    public List<Integer> getlPreyIndex() {
        return lPreyIndex;
    }

    /**
     * @param lPreyIndex the lPreyIndex to set
     */
    public void setlPreyIndex(List<Integer> lPreyIndex) {
        this.lPreyIndex = lPreyIndex;
    }

    /**
     * @return the lPredatorIndex
     */
    public List<Integer> getlPredatorIndex() {
        return lPredatorIndex;
    }

    /**
     * @param lPredatorIndex the lPredatorIndex to set
     */
    public void setlPredatorIndex(List<Integer> lPredatorIndex) {
        this.lPredatorIndex = lPredatorIndex;
    }

    /**
     * @return the speciesCount
     */
    public int getSpeciesCount() {
        return speciesCount;
    }

    /**
     * @param speciesCount the speciesCount to set
     */
    public void setSpeciesCount(int speciesCount) {
        this.speciesCount = speciesCount;
    }

    /**
     * @return the perSpeciesBiomass
     */
    public double getPerSpeciesBiomass() {
        return perSpeciesBiomass;
    }

    /**
     * @param perSpeciesBiomass the perSpeciesBiomass to set
     */
    public void setPerSpeciesBiomass(double perSpeciesBiomass) {
        this.perSpeciesBiomass = perSpeciesBiomass;
    }

    /**
     * @return the currentBiomass
     */
    public double getCurrentBiomass() {
        return currentBiomass;
    }

    /**
     * @param currentBiomass the currentBiomass to set
     */
    public void setCurrentBiomass(double currentBiomass) {
        this.currentBiomass = currentBiomass;
        this.biomassUpdated = true;
    }
    
    public boolean isBiomassUpdated()
    {
        return this.biomassUpdated;
        
    }
    
    public void setBiomassUpdate(boolean val)
    {
        this.biomassUpdated = val;
    }
    /**
     * @return the lPrey
     */
    public List<SpeciesType> getlPrey() {
        return lPrey;
    }

    /**
     * @param lPrey the lPrey to set
     */
    public void setlPrey(List<SpeciesType> lPrey) {
        this.lPrey = lPrey;
    }

    /**
     * @return the lPredator
     */
    public List<SpeciesType> getlPredator() {
        return lPredator;
    }

    /**
     * @param lPredator the lPredator to set
     */
    public void setlPredator(List<SpeciesType> lPredator) {
        this.lPredator = lPredator;
    }

    /**
     * @return the type
     */
    public SpeciesTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(SpeciesTypeEnum type) {
        this.type = type;
    }

    public double getTrophicLevel() {
        return trophicLevel;
    }

    public double setTrophicLevel(double trophicLevel) {
        return this.trophicLevel = trophicLevel;
    }

    public double getParamK() {
        return paramK;
    }

    public void setParamK(double paramK) {
        this.paramK = paramK;
    }

    public double getParamR() {
        return paramR;
    }

    public void setParamR(double paramR) {
        this.paramR = paramR;
    }

    public double getParamX() {
        return paramX;
    }

    public void setParamX(double paramX) {
        this.paramX = paramX;
    }    
    
    public List<ParamValue> getParamA() {
        return paramA;
    }

    public void setParamA(List<ParamValue> paramA) {
        this.paramA = paramA;
    }
    
    public ParamValue getParamA(int preyIdx)
    {
        if(paramA == null)
            return null;
        
        for(ParamValue val :paramA)
        {
            if(val.getPreyIdx() == preyIdx)
                return val;
        }
        return null;
    }    

    public List<ParamValue> getParamD() {
        return paramD;
    }

    public void setParamD(List<ParamValue> paramD) {
        this.paramD = paramD;
    }
    
    public ParamValue getParamD(int preyIdx)
    {
        if(paramD == null)
            return null;
        
        for(ParamValue val :paramD)
        {
            if(val.getPreyIdx() == preyIdx)
                return val;
        }
        return null;
    }    

    public List<ParamValue> getParamE() {
        return paramE;
    }
    
    public ParamValue getParamE(int preyIdx)
    {
        if(paramE == null)
            return null;
        
        for(ParamValue val :paramE)
        {
            if(val.getPreyIdx() == preyIdx)
                return val;
        }
        return null;
    }

    public void setParamE(List<ParamValue> paramE) {
        this.paramE = paramE;
    }

    public List<ParamValue> getParamQ() {
        return paramQ;
    }

    public void setParamQ(List<ParamValue> paramQ) {
        this.paramQ = paramQ;
    }
    
    public ParamValue getParamQ(int preyIdx)
    {
        if(paramQ == null)
            return null;
        
        for(ParamValue val :paramQ)
        {
            if(val.getPreyIdx() == preyIdx)
                return val;
        }
        return null;
    }    
}
