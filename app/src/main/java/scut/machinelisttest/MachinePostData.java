package scut.machinelisttest;

/**
 用来装用于POST搜索请求的json数据的JavaBean
 */
public class MachinePostData {
    private String requestType;

    private String productType;

    private String material;

    private String crumble;

    private String CaCo3;

    private String fiberglass;

    private String fireproofing;

    private String color;

    private double productWeight;

    private double productLength;

    private double productWidth;

    private double productHeight;

    private double wallThickness;

    private double modulLength;

    private double modulWidth;

    private double modulHeight;

    private String ejector;

    private double locatingRing;

    private String screw;

    private String power;

    public void setRequestType(String requestType){
        this.requestType = requestType;
    }
    public String getRequestType(){
        return this.requestType;
    }
    public void setProductType(String productType){
        this.productType = productType;
    }
    public String getProductType(){
        return this.productType;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public String getMaterial(){
        return this.material;
    }
    public void setCrumble(String crumble){
        this.crumble = crumble;
    }
    public String getCrumble(){
        return this.crumble;
    }
    public void setCaCo3(String CaCo3){
        this.CaCo3 = CaCo3;
    }
    public String getCaCo3(){
        return this.CaCo3;
    }
    public void setFiberglass(String fiberglass){
        this.fiberglass = fiberglass;
    }
    public String getFiberglass(){
        return this.fiberglass;
    }
    public void setFireproofing(String fireproofing){
        this.fireproofing = fireproofing;
    }
    public String getFireproofing(){
        return this.fireproofing;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }
    public void setProductWeight(double productWeight){
        this.productWeight = productWeight;
    }
    public double getProductWeight(){
        return this.productWeight;
    }
    public void setProductLength(double productLength){
        this.productLength = productLength;
    }
    public double getProductLength(){
        return this.productLength;
    }
    public void setProductWidth(double productWidth){
        this.productWidth = productWidth;
    }
    public double getProductWidth(){
        return this.productWidth;
    }
    public void setProductHeight(double productHeight){
        this.productHeight = productHeight;
    }
    public double getProductHeight(){
        return this.productHeight;
    }
    public void setWallThickness(double wallThickness){
        this.wallThickness = wallThickness;
    }
    public double getWallThickness(){
        return this.wallThickness;
    }
    public void setModulLength(double modulLength){
        this.modulLength = modulLength;
    }
    public double getModulLength(){
        return this.modulLength;
    }
    public void setModulWidth(double modulWidth){
        this.modulWidth = modulWidth;
    }
    public double getModulWidth(){
        return this.modulWidth;
    }
    public void setModulHeight(double modulHeight){
        this.modulHeight = modulHeight;
    }
    public double getModulHeight(){
        return this.modulHeight;
    }
    public void setEjector(String ejector){
        this.ejector = ejector;
    }
    public String getEjector(){
        return this.ejector;
    }
    public void setLocatingRing(double locatingRing){
        this.locatingRing = locatingRing;
    }
    public double getLocatingRing(){
        return this.locatingRing;
    }
    public void setScrew(String screw){
        this.screw = screw;
    }
    public String getScrew(){
        return this.screw;
    }
    public void setPower(String power){
        this.power = power;
    }
    public String getPower(){
        return this.power;
    }
}
