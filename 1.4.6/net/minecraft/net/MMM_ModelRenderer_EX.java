package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import modelAppend.*;

public class MMM_ModelRenderer_EX extends MMM_ModelRenderer{

	float scaleX=1.0f;
	float scaleY=1.0f;
	float scaleZ=1.0f;

	public MMM_ModelRenderer_EX(ModelBase pModelBase,String pName){
		super(pModelBase,pName);
	}

	public MMM_ModelRenderer_EX(ModelBase pModelBase,int px,int py){
		super(pModelBase,px,py);
	}

	public MMM_ModelRenderer_EX(ModelBase pModelBase){
		super(pModelBase);
	}

	public MMM_ModelRenderer_EX(ModelBase pModelBase,int px,int py,float scaleX,float scaleY,float scaleZ){
		this(pModelBase,px,py);
		this.scaleX=scaleX;
		this.scaleY=scaleY;
		this.scaleZ=scaleZ;
	}

	public MMM_ModelRenderer_EX(ModelBase pModelBase,float scaleX,float scaleY,float scaleZ){
		this(pModelBase);
		this.scaleX=scaleX;
		this.scaleY=scaleY;
		this.scaleZ=scaleZ;
	}

	public MMM_ModelRenderer_EX addPlateFreeShape(float vertex[][], float texUV[][], float vertexN[][],float RGBA[])
    {
        cubeList.add(new ModelPlateFreeShape(this, textureOffsetX, textureOffsetY, vertex, texUV, vertexN, RGBA, 0));
        return this;
    }

	public MMM_ModelRenderer_EX addBall(float xOffset, float yOffset, float zOffset, float xScale, float yScale, float zScale){//, int ux, int uy){
		return makeBall(xOffset, yOffset, zOffset, xScale, yScale, zScale);//, ux, uy);
	}

	public void setScale(float scaleX,float scaleY,float scaleZ){
		this.scaleX=scaleX;
		this.scaleY=scaleY;
		this.scaleZ=scaleZ;
	}

	@Override
	public void renderObject(float par1, EntityLiving pEntityLiving) {
    	// �����_�����O�A���Ǝq����
		GL11.glScalef(scaleX, scaleY, scaleZ);
        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
        GL11.glCallList(displayList);
        GL11.glScalef(1f/scaleX, 1f/scaleY, 1f/scaleZ);

        if (childModels != null) {
            for (int i = 0; i < childModels.size(); i++) {
                ((MMM_ModelRenderer)childModels.get(i)).render(par1, pEntityLiving);
            }
        }
    }

	@Override
	public void render(float par1,EntityLiving pEntityLiving){
		if (isHidden)
        {
            return;
        }

        if (!showModel)
        {
            return;
        }

        if (!compiled)
        {
            compileDisplayList(par1);
        }

        if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

            // �ϊ����ʂ̐ݒ�
            switch (rotatePriority) {
            case RotXYZ:
                if (rotateAngleZ != 0.0F) {
                    GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }
                if (rotateAngleY != 0.0F) {
                    GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }
                if (rotateAngleX != 0.0F) {
                    GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }
            	break;
            case RotXZY:
                if (rotateAngleY != 0.0F) {
                    GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }
                if (rotateAngleZ != 0.0F) {
                    GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }
                if (rotateAngleX != 0.0F) {
                    GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }
            	break;
            case RotYXZ:
                if (rotateAngleZ != 0.0F) {
                    GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }
                if (rotateAngleX != 0.0F) {
                    GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }
                if (rotateAngleY != 0.0F) {
                    GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }
            	break;
            case RotYZX:
                if (rotateAngleX != 0.0F) {
                    GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }
                if (rotateAngleZ != 0.0F) {
                    GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }
                if (rotateAngleY != 0.0F) {
                    GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }
            	break;
            case RotZXY:
                if (rotateAngleY != 0.0F) {
                    GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }
                if (rotateAngleX != 0.0F) {
                    GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }
                if (rotateAngleZ != 0.0F) {
                    GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }
            	break;
            case RotZYX:
                if (rotateAngleX != 0.0F) {
                    GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }
                if (rotateAngleY != 0.0F) {
                    GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }
                if (rotateAngleZ != 0.0F) {
                    GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }
            	break;
            }
       //     GL11.glScalef(scaleX, scaleY, scaleZ);
            renderObject(par1, pEntityLiving);
       //     GL11.glScalef(1f/scaleX, 1f/scaleY, 1f/scaleZ);

            GL11.glPopMatrix();
        }
        else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F)
        {
            GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

       //     GL11.glScalef(scaleX, scaleY, scaleZ);
            renderObject(par1, pEntityLiving);
       //     GL11.glScalef(1f/scaleX, 1f/scaleY, 1f/scaleZ);

            GL11.glTranslatef(-rotationPointX * par1, -rotationPointY * par1, -rotationPointZ * par1);
        }
        else
        {
        //	GL11.glScalef(scaleX, scaleY, scaleZ);
            renderObject(par1, pEntityLiving);
        //    GL11.glScalef(1f/scaleX, 1f/scaleY, 1f/scaleZ);
        }
	}

	private MMM_ModelRenderer_EX makeBall(float xOffset, float yOffset, float zOffset, float xScale, float yScale, float zScale){//, int ux, int uy){
		float v[][]={
				{0.0f,4.9745197f,-0.0f},
				{0.0f,3.5175202f,3.5175202f},
				{2.4997f,3.5175202f,2.4872599f},
				{3.5351f,3.5175202f,-0.0f},
				{2.4997f,3.5175202f,-2.4872599f},
				{0.0f,3.5175202f,-3.5175202f},
				{-2.4997f,3.5175202f,-2.4872599f},
				{-3.5351f,3.5175202f,-0.0f},
				{-2.4997f,3.5175202f,2.4872599f},
				{0.0f,0.0f,4.9745197f},
				{3.5351f,0.0f,3.5175202f},
				{4.99939f,0.0f,0.0f},
				{3.5351f,-0.0f,-3.5175202f},
				{0.0f,-0.0f,-4.9745197f},
				{-3.5351f,-0.0f,-3.5175202f},
				{-4.99939f,0.0f,0.0f},
				{-3.5351f,0.0f,3.5175202f},
				{0.0f,-3.5175202f,3.5175202f},
				{2.4997f,-3.5175202f,2.4872599f},
				{3.5351f,-3.5175202f,0.0f},
				{2.4997f,-3.5175202f,-2.4872599f},
				{0.0f,-3.5175202f,-3.5175202f},
				{-2.4997f,-3.5175202f,-2.4872599f},
				{-3.5351f,-3.5175202f,0.0f},
				{-2.4997f,-3.5175202f,2.4872599f},
				{0.0f,-4.9745197f,0.0f}
				};
				float vt[][]={
				{((float)textureOffsetX/(float)textureWidth),((float)(textureOffsetY+1)/(float)textureHeight)},
				{((float)(textureOffsetX+1)/(float)textureWidth),((float)(textureOffsetY+1)/(float)textureHeight)},
				{((float)(textureOffsetX+1)/(float)textureWidth),((float)textureOffsetY/(float)textureHeight)},
				{((float)textureOffsetX/(float)textureWidth),((float)textureOffsetY/(float)textureHeight)}
				};
				float vn[][]={
				{0.0f,1.0f,0.0f},
				{0.0f,0.663167f,0.748436f},
				{0.527909f,0.663594f,0.529984f},
				{0.747673f,0.664052f,0.0f},
				{0.527909f,0.663594f,-0.529984f},
				{0.0f,0.663167f,-0.748436f},
				{-0.527909f,0.663594f,-0.529984f},
				{-0.747673f,0.664052f,0.0f},
				{-0.527909f,0.663594f,0.529984f},
				{0.0f,0.0f,0.999969f},
				{0.706076f,0.0f,0.70809f},
				{1.0f,0.0f,0.0f},
				{0.706107f,0.0f,-0.70809f},
				{0.0f,0.0f,-0.999969f},
				{-0.706076f,0.0f,-0.70809f},
				{-1.0f,0.0f,0.0f},
				{-0.706107f,0.0f,0.70809f},
				{0.0f,-0.663167f,0.748436f},
				{0.527909f,-0.663594f,0.529984f},
				{0.747673f,-0.664052f,0.0f},
				{0.527909f,-0.663594f,-0.529984f},
				{0.0f,-0.663167f,-0.748436f},
				{-0.527909f,-0.663594f,-0.529984f},
				{-0.747673f,-0.664052f,0.0f},
				{-0.527909f,-0.663594f,0.529984f},
				{0.0f,-1.0f,0.0f}
				};
				int faceis[][][]={
				{{1},{0,1,2},{0,1,2},{0,1,2}},
				{{1},{0,2,3},{0,1,2},{0,2,3}},
				{{1},{0,3,4},{0,1,2},{0,3,4}},
				{{1},{0,4,5},{0,1,2},{0,4,5}},
				{{1},{0,5,6},{0,1,2},{0,5,6}},
				{{1},{0,6,7},{0,1,2},{0,6,7}},
				{{1},{0,7,8},{0,1,2},{0,7,8}},
				{{1},{0,8,1},{0,1,2},{0,8,1}},
				{{1},{1,9,10,2},{0,1,2,3},{1,9,10,2}},
				{{1},{2,10,11,3},{0,1,2,3},{2,10,11,3}},
				{{1},{3,11,12,4},{0,1,2,3},{3,11,12,4}},
				{{1},{4,12,13,5},{0,1,2,3},{4,12,13,5}},
				{{1},{5,13,14,6},{0,1,2,3},{5,13,14,6}},
				{{1},{6,14,15,7},{0,1,2,3},{6,14,15,7}},
				{{1},{7,15,16,8},{0,1,2,3},{7,15,16,8}},
				{{1},{8,16,9,1},{0,1,2,3},{8,16,9,1}},
				{{1},{9,17,18,10},{0,1,2,3},{9,17,18,10}},
				{{1},{10,18,19,11},{0,1,2,3},{10,18,19,11}},
				{{1},{11,19,20,12},{0,1,2,3},{11,19,20,12}},
				{{1},{12,20,21,13},{0,1,2,3},{12,20,21,13}},
				{{1},{13,21,22,14},{0,1,2,3},{13,21,22,14}},
				{{1},{14,22,23,15},{0,1,2,3},{14,22,23,15}},
				{{1},{15,23,24,16},{0,1,2,3},{15,23,24,16}},
				{{1},{16,24,17,9},{0,1,2,3},{16,24,17,9}},
				{{1},{17,25,18},{0,1,2},{17,25,18}},
				{{1},{18,25,19},{0,1,2},{18,25,19}},
				{{1},{19,25,20},{0,1,2},{19,25,20}},
				{{1},{20,25,21},{0,1,2},{20,25,21}},
				{{1},{21,25,22},{0,1,2},{21,25,22}},
				{{1},{22,25,23},{0,1,2},{22,25,23}},
				{{1},{23,25,24},{0,1,2},{23,25,24}},
				{{1},{24,25,17},{0,1,2},{24,25,17}}
				};

				for(int n=0;n<v.length;n++){
					v[n][0]*=xScale/8f;
					v[n][1]*=yScale/8f;
					v[n][2]*=zScale/8f;
					v[n][0]+=xOffset;
					v[n][1]+=yOffset;
					v[n][2]+=zOffset;
				}

				for(int i=0;i<faceis.length;i++){
					int k=faceis[i][1].length;
					float ver[][]=new float[k][3];
					float verTex[][]=new float[k][2];
					float verN[][]=new float[k][3];
					if(faceis[i][0][0]==1){
						for(int j=0;j<k;j++){
							ver[j]=v[faceis[i][1][j]];
							verTex[j]=vt[faceis[i][2][j]];
							verN[j]=vn[faceis[i][3][j]];
						}
						this.addPlateFreeShape(ver,verTex,verN,null);
					}
				}
				return this;
	}
/*	@Override
    public void postRender(float par1)
    {
        if (isHidden)
        {
            return;
        }

        if (!showModel)
        {
            return;
        }

        if (!compiled)
        {
            compileDisplayList(par1);
        }

        if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F)
        {
            GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

            if (rotateAngleZ != 0.0F)
            {
                GL11.glRotatef(rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
            }

            if (rotateAngleY != 0.0F)
            {
                GL11.glRotatef(rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
            }

            if (rotateAngleX != 0.0F)
            {
                GL11.glRotatef(rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
            }
        }
        else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F)
        {
            GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
        }
    }*/
}
