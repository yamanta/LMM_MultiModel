package modelAppend;

import net.minecraft.src.*;

public class ModelPlateFreeShape extends ModelBox
{
    private PositionTextureVertex vertexPositions[];
    private TexturedTriangle triList[];

    /** X vertex coordinate of lower box corner */
    public final float posX1;

    /** Y vertex coordinate of lower box corner */
    public final float posY1;

    /** Z vertex coordinate of lower box corner */
    public final float posZ1;

    /** X vertex coordinate of upper box corner */
    public final float posX2;

    /** Y vertex coordinate of upper box corner */
    public final float posY2;

    /** Z vertex coordinate of upper box corner */
    public final float posZ2;

    /** X vertex coordinate of upper box corner */
    public final float posX3;

    /** Y vertex coordinate of upper box corner */
    public final float posY3;

    /** Z vertex coordinate of upper box corner */
    public final float posZ3;

    public final float vn[][];

    /**
     *
     * @param modelrenderer
     * @param i : textureOffsetX
     * @param j : textureOffsetY
     * @param f : PositionOffsetX
     * @param f1 : PositionOffsetY
     * @param f2 : PositionOffsetZ
     * @param k : length or depthX(depthZ, depthX)
     * @param l : angle, in Degree, or depthY(depthY, depthZ)
     * @param i1 : Select Plane and Triangle Shape; Sum Plane No. and Shape No.
     *  <ul>
     * Plane No.<br>
     * <ul>
     * 0 : XY Plane<br>
     * 1 : YZ Plane<br>
     * 2 : XZ Plane<br>
     * </ul>
     * Shape No.<br>
     * <ul>
     * 0 : Isosceles triangle<br>
     * 4 : Right-angled triangle
     * </ul>
     * </ul>
     * @param f3 : scale
     */
    public ModelPlateFreeShape(ModelRenderer modelrenderer, int i, int j, float vertex[][], float texUV[][], float vertexN[][], float RGBA[],float f3)
    {
        super(modelrenderer, i, j, 0, 0, 0, 0, 0, 0, f3);
        float x1;
        float y1;
        float z1;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;

        int n=vertex.length;
   /*     posX1=x1=f+vertex[0][0];
        posY1=y1=f1+vertex[0][1];
        posZ1=z1=f2+vertex[0][2];
        posX2=f4=f+vertex[1][0];
        posY2=f5=f1+vertex[1][1];
        posZ2=f6=f2+vertex[1][2];
        posX3=f10=f+vertex[2][0];
        posY3=f11=f1+vertex[2][1];
        posZ3=f12=f2+vertex[2][2];*/

        posX1=x1=vertex[0][0];
        posY1=y1=vertex[0][1];
        posZ1=z1=vertex[0][2];
        posX2=f4=vertex[1][0];
        posY2=f5=vertex[1][1];
        posZ2=f6=vertex[1][2];
        posX3=f10=vertex[2][0];
        posY3=f11=vertex[2][1];
        posZ3=f12=vertex[2][2];
        vn=vertexN;

        float tex_x=8F;
        float tex_y=8F;


        vertexPositions = new PositionTextureVertex[n];
        triList = new TexturedTriangle[1];

        for(int l=0;l<n;l++){
        	vertexPositions[l]=new PositionTextureVertex(vertex[l][0], vertex[l][1], vertex[l][2], 0.0F, 0.0F);
        }
    /*    PositionTextureVertex positiontexturevertex = new PositionTextureVertex(x1, y1, z1, 0.0F, 0.0F);
        PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(f4, f5, f6, 0.0F, 8F);
        PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(f10, f11, f12, 8F, 0.0F);
        PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(f7, f8, f9, 0.0F, 8F);*/
   /*     vertexPositions[0] = positiontexturevertex;
        vertexPositions[1] = positiontexturevertex1;
    //    vertexPositions[2] = positiontexturevertex2;
        vertexPositions[2] = positiontexturevertex3;*/




     /*   if(modelrenderer.mirror==true){
        	quadList[0] = new TexturedQuad(new PositionTextureVertex[]
                    {
                        positiontexturevertex2, positiontexturevertex3, positiontexturevertex, positiontexturevertex1
                    }, i, j, i + k, j + k, modelrenderer.textureWidth, modelrenderer.textureHeight);
        }
        else{*/
        float TexVertex[][]=new float[3][2];
        	TexVertex[0][0]=(float)i+tex_x;
        	TexVertex[0][1]=(float)j;
        	TexVertex[1][0]=(float)i;
        	TexVertex[1][1]=(float)j;
        	TexVertex[2][0]=(float)i;
        	TexVertex[2][1]=(float)j+tex_y;
        	triList[0] = new TexturedTriangle(vertexPositions, texUV, vn, RGBA, 0, 0);
    /*    	if(vn!=null){
        		System.out.println(String.format("ModelPlateTriFree : normal1(%.6f,%.6f, %.6f)",vn[0][0],vn[0][1],vn[0][2]));
        		System.out.println(String.format("ModelPlateTriFree : normal2(%.6f,%.6f, %.6f)",vn[1][0],vn[1][1],vn[1][2]));
        		System.out.println(String.format("ModelPlateTriFree : normal3(%.6f,%.6f, %.6f)",vn[2][0],vn[2][1],vn[2][2]));
        	}*/
        if(modelrenderer.mirror==true){
        	for(i=0;i<triList.length;i++){
        		triList[i].flipFace();
        	}
        }
        try
        {
            ModLoader.setPrivateValue(net.minecraft.src.ModelBox.class, this, 0, vertexPositions);
            ModLoader.setPrivateValue(net.minecraft.src.ModelBox.class, this, 1, triList);
        }
        catch (Exception exception) { }
    }

    public void render(Tessellator par1Tessellator, float par2)
    {
        for (int i = 0; i < triList.length; i++)
        {
            triList[i].draw(par1Tessellator, par2);
        }
    }
}
