package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelLittleMaid_ChibiNeko extends LMM_ModelLittleMaid_Archetype {

	public MMM_ModelRenderer eyeR;
	public MMM_ModelRenderer eyeL;
	public MMM_ModelRenderer Prim;
	public MMM_ModelRenderer Tail2;
	public MMM_ModelRenderer Tail3;
	public MMM_ModelRenderer Tail4;
	public MMM_ModelRenderer Tail5;
	public MMM_ModelRenderer Tail6;
	public MMM_ModelRenderer Ahoge;
	public MMM_ModelRenderer_EX Skirt21;
	public MMM_ModelRenderer_EX Skirt22;
	public MMM_ModelRenderer_EX Skirt23;
	public MMM_ModelRenderer_EX Skirt24;
	public MMM_ModelRenderer_EX Skirt25;
	public MMM_ModelRenderer_EX Skirt26;
	public MMM_ModelRenderer_EX Skirt27;
	public MMM_ModelRenderer_EX Skirt28;
	public MMM_ModelRenderer_EX Skirt29;
	public MMM_ModelRenderer_EX Skirt210;
	public MMM_ModelRenderer_EX Skirt211;
	public MMM_ModelRenderer_EX Skirt212;
	public MMM_ModelRenderer_EX Skirt213;
	public MMM_ModelRenderer_EX Skirt214;
	public MMM_ModelRenderer_EX Skirt215;
	public MMM_ModelRenderer_EX Skirt216;
	public MMM_ModelRenderer_EX Band1;
	public MMM_ModelRenderer_EX EarL1;
	public MMM_ModelRenderer_EX EarL2;
	public MMM_ModelRenderer_EX EarR1;
	public MMM_ModelRenderer_EX EarR2;
	public MMM_ModelRenderer_EX EarLi1;
	public MMM_ModelRenderer_EX EarLi2;
	public MMM_ModelRenderer_EX EarRi1;
	public MMM_ModelRenderer_EX EarRi2;
	public MMM_ModelRenderer Shippo1;
	public MMM_ModelRenderer Shippo2;
	public MMM_ModelRenderer Shippo3;
	public MMM_ModelRenderer Shippo4;
	public MMM_ModelRenderer Shippo5;
	public MMM_ModelRenderer Shippo6;
	public MMM_ModelRenderer_EX Glass;
	public MMM_ModelRenderer DrowaR1;
	public MMM_ModelRenderer DrowaL1;
	public MMM_ModelRenderer DrowaR2;
	public MMM_ModelRenderer DrowaL2;

	private static final float Scale=0.4F;

	private int IdOffset;

	public ModelLittleMaid_ChibiNeko()
	{
		this(0.0F);
	}

	public ModelLittleMaid_ChibiNeko(float f)
	{
		this(f, 0.0F);
	}

	public ModelLittleMaid_ChibiNeko(float f, float f1)
	{
		super(f, f1);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
		super.initModel(psize, pyoffset);

		textureHeight=64;
		textureWidth=64;

		heldItemLeft = 0;
        heldItemRight = 0;
        isSneak = false;
        isWait = false;
        aimedBow = false;

		pyoffset += 8F;

		Arms = new MMM_ModelRenderer[2];
		Arms[0] = new MMM_ModelRenderer(this, 0, 0);
		Arms[0].setRotationPointLM(-1F, 5F, -1F);
		Arms[1] = new MMM_ModelRenderer(this, 0, 0);
		Arms[1].setRotationPoint(1F, 5F, -1F);
		Arms[1].isInvertX = true;
		HeadMount.setRotationPoint(0F, -2.8F, 0F);

		bipedCloak = new ModelRenderer(this, 0, 0);
		bipedCloak.addBox(-5F, 0.0F, -1F, 10, 16, 1, psize);
		bipedCloak.showModel = false;
		bipedEars = new ModelRenderer(this, 0, 16);
		bipedEars.addBox(-3F, -6F, -1F, 6, 6, 1, psize);
		bipedEars.showModel = false;

		bipedHead = new MMM_ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, psize-Scale);
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.addChild(HeadMount);

		bipedHeadwear = new MMM_ModelRenderer(this, 24, 0);
		bipedHeadwear.addBox(-4F, 0.0F, 1.0F, 8, 4, 3, psize);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
//		bipedHeadwear.parentModel = bipedHead;
		bipedHead.addChild(bipedHeadwear);
		bipedHeadwear.isHidden=true;

		bipedBody = new MMM_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3F, 0.0F, -2F, 6, 7, 4, psize-Scale);
		bipedBody.setRotationPoint(0.0F, 3.0F*Scale, 0.0F);
		bipedRightLeg = new MMM_ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-2F, 0.0F, -2F, 3, 9, 4, psize-Scale);
		bipedRightLeg.setRotationPoint(-0.9F, 7.0F+ Scale, 0.0F);
		bipedLeftLeg = new MMM_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1F, 0.0F, -2F, 3, 9, 4, psize-Scale);
		bipedLeftLeg.setRotationPoint(0.9F, 7.0F+ Scale, 0.0F);

		DrowaR1 = new MMM_ModelRenderer(this, 46, 25);
		DrowaR1.addBox(-2F, -0.0F, -2F, 3, 2, 4, psize-0.1F);
		DrowaR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(DrowaR1);

		DrowaL1 = new MMM_ModelRenderer(this, 46, 25);
		DrowaL1.mirror = true;
		DrowaL1.addBox(-1F, -0.0F, -2F, 3, 2, 4, psize-0.1F);
		DrowaL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(DrowaL1);

		DrowaR2 = new MMM_ModelRenderer(this, 46, 25);
		DrowaR2.addBox(-1.5F, 0F, -2F, 3, 2, 4, psize);
	//	DrowaR2.setPreRotationPointLM(-1.5F, 7.5F-f1, 0.0F);
	//	DrowaR2.parentModel=Skirt;
		Skirt.addChild(DrowaR2);

		DrowaL2 = new MMM_ModelRenderer(this, 46, 25);
		DrowaL2.mirror = true;
		DrowaL2.addBox(-1.5F, 0F, -2F, 3, 2, 4, psize);
	//	DrowaL2.setPreRotationPointLM(1.5F, 7.5F-f1, 0.0F);
	//	DrowaL2.parentModel=Skirt;
		Skirt.addChild(DrowaL2);

		Skirt = new MMM_ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -2F, -4F, 0, 0, 0, psize);
		Skirt.setRotationPoint(0.0F, 7F, 0.0F);

		bipedRightArm = new MMM_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-2F, -1F, -1F, 2, 8, 2, psize-Scale);
		bipedRightArm.setRotationPointLM(-2.1F, 1.5F + 2*Scale, 0F);
		bipedRightArm.addChild(Arms[0]);

		bipedLeftArm = new MMM_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(0.0F, -1F, -1F, 2, 8, 2, psize-Scale);
		bipedLeftArm.setRotationPointLM(2.1F, 1.5F + 2*Scale, 0F);
		bipedLeftArm.addChild(Arms[1]);

	//	Skirt.isHidden=true;

		eyeR = new MMM_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -4.9F, -4.001F, 4, 4, 0, psize-Scale);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new MMM_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, psize-Scale);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);

		Glass = new MMM_ModelRenderer_EX(this, 24, 0,0.47F,0.47F,1.0F);
		Glass.addPlate(-8.0F, -4.0F, 0F, 16, 8, 0, psize-Scale);
		Glass.setRotationPointLM(0.0F, -4.5F + 2.0F*Scale, -4.0F);
	//	Glass.parentModel=bipedHead;
		bipedHead.addChild(Glass);

		Prim = new MMM_ModelRenderer(this, 4, 0);
		Prim.addPlate(-2F, -7.3F, -3.5F, 4, 1, 0, psize-Scale/2);
	//	Prim.setPreRotationPointLM(0.0F, -0.0F + Scale, 0.0F);
	//	Prim.parentModel = bipedHead;
		bipedHead.addChild(Prim);

		ChignonR = new MMM_ModelRenderer(this, 24, 18);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, psize);
		ChignonR.setRotationPointLM(0F, 0F, 0F);
	//	ChignonR.parentModel = bipedHead;
		bipedHead.addChild(ChignonR);
		ChignonR.isHidden=true;

		ChignonL = new MMM_ModelRenderer(this, 24, 24);
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3,psize);
		ChignonL.setRotationPointLM(0F, 0F, 0F);
	//	ChignonL.parentModel = bipedHead;
		bipedHead.addChild(ChignonL);
		ChignonL.isHidden=true;

		ChignonB = new MMM_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.5F, 3.1F, 4, 4, 2,psize-0.5F);
		ChignonB.setRotationPointLM(0F, 0F, 0F);
	//	ChignonB.parentModel = bipedHead;
		bipedHead.addChild(ChignonB);

		SideTailL = new MMM_ModelRenderer(this, 46, 26);
		SideTailL.addBox(4.7F, -6F, 1F, 1, 1, 1,psize+0.2F);
		SideTailL.setRotationPointLM(0F, 0F, 0F);
	//	SideTailL.parentModel = bipedHead;
		bipedHead.addChild(SideTailL);
		SideTailL.isHidden=true;

		SideTailR = new MMM_ModelRenderer(this, 50, 26);
		SideTailR.addBox(-5.7F, -6F, 1F, 1, 1, 1,psize+0.2F);
		SideTailR.setRotationPointLM(0F, 0F, 0F);
	//	SideTailR.parentModel = bipedHead;
		bipedHead.addChild(SideTailR);
		SideTailR.isHidden=true;

		Tail = new MMM_ModelRenderer(this, 46, 19);
		Tail.addBox(-1F, -6.5F, 4.5F, 2, 2, 2,psize+0.1F);
		Tail.setRotationPointLM(0F, 0.0F, 0F);
	//	Tail.parentModel = bipedHead;
		bipedHead.addChild(Tail);

		Tail2 = new MMM_ModelRenderer(this, 46, 15);
		Tail2.addBox(0F, 1F, 0F, 2, 7, 2,psize);
		Tail2.setRotationPointLM(-1F, -6.0F, 4.7F);
		bipedHead.addChild(Tail2);
		Tail2.isHidden=true;

		Tail3 = new MMM_ModelRenderer(this, 54, 15);
		Tail3.addBox(0F, 1F, 0F, 0, 8, 2,psize+0.0001F);
		Tail3.setRotationPointLM(-0.5F, -6.8F, 4.5F);
		bipedHead.addChild(Tail3);
		setRotationDeg(Tail3,0F,0F,0F);
		setRotationDeg(Tail3,0F,0F,0F);

		Tail4 = new MMM_ModelRenderer(this, 54, 16);
		Tail4.addPlate(0F, 1F, 0F, 2, 8, 0,psize);
		Tail4.setRotationPointLM(-1.0F, -6.8F, 5.0F);
		bipedHead.addChild(Tail4);
		setRotationDeg(Tail4,0F,0F,0F);
		setRotationDeg(Tail4,0F,0F,0F);

		Tail5 = new MMM_ModelRenderer(this, 54, 15);
		Tail5.addBox(0F, 1F, 0F, 0, 8, 2,psize+0.0001F);
		Tail5.setRotationPointLM(0.5F, -6.8F, 4.5F);
		bipedHead.addChild(Tail5);
		setRotationDeg(Tail5,0F,0F,0F);
		setRotationDeg(Tail5,0F,0F,0F);

		Tail6 = new MMM_ModelRenderer(this, 54, 16);
		Tail6.mirror=true;
		Tail6.addPlate(0F, 1F, 0F, 2, 8, 0,psize);
		Tail6.setRotationPointLM(-1.0F, -6.8F, 6.0F);
		bipedHead.addChild(Tail6);
		setRotationDeg(Tail6,0F,0F,0F);
		setRotationDeg(Tail6,0F,0F,0F);

		Ahoge = new MMM_ModelRenderer(this, 0, 1);
		Ahoge.addBox(0F, 0F, 0F, 0, 3, 4,psize+0.0001F);
		Ahoge.setRotationPointLM(0F, -6.8F+Scale, -3.8F+Scale);
	//	Ahoge.setPreRotationPointLM(0F, 0.0F+f1+5.0F*Scale, 0.1F);
		bipedHead.addChild(Ahoge);

		mainFrame = new MMM_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
		mainFrame.addChild(bipedRightArm);
		mainFrame.addChild(bipedLeftArm);
		mainFrame.addChild(bipedRightLeg);
		mainFrame.addChild(bipedLeftLeg);
		mainFrame.addChild(Skirt);

		Skirt21 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt21.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt21.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt21.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt21.parentModel=Skirt;
		Skirt.addChild(Skirt21);
		setRotatePriorityYZX(Skirt21);

		Skirt22 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt22.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt22.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt22.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt22.parentModel=Skirt;
		Skirt.addChild(Skirt22);
		setRotatePriorityYZX(Skirt22);

		Skirt23 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt23.addPlate(0F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt23.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	//	Skirt23.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt23.parentModel=Skirt;
		Skirt.addChild(Skirt23);
		setRotatePriorityYZX(Skirt23);

		Skirt24 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt24.addPlate(0F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt24.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	//	Skirt24.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt24.parentModel=Skirt;
		Skirt.addChild(Skirt24);
		setRotatePriorityYZX(Skirt24);

		Skirt25 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt25.addPlate(0F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt25.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	//	Skirt25.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt25.parentModel=Skirt;
		Skirt.addChild(Skirt25);
		setRotatePriorityYZX(Skirt25);

		Skirt26 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt26.addPlate(0F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt26.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	//	Skirt26.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt26.parentModel=Skirt;
		Skirt.addChild(Skirt26);
		setRotatePriorityYZX(Skirt26);

		Skirt27 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt27.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt27.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt27.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt27.parentModel=Skirt;
		Skirt.addChild(Skirt27);
		setRotatePriorityYZX(Skirt27);

		Skirt28 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt28.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt28.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt28.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt28.parentModel=Skirt;
		Skirt.addChild(Skirt28);
		setRotatePriorityYZX(Skirt28);

		Skirt29 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt29.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt29.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt29.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt29.parentModel=Skirt;
		Skirt.addChild(Skirt29);
		setRotatePriorityYZX(Skirt29);

		Skirt210 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt210.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt210.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt210.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt210.parentModel=Skirt;
		Skirt.addChild(Skirt210);
		setRotatePriorityYZX(Skirt210);

		Skirt211 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt211.addPlate(0F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt211.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	//	Skirt211.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt211.parentModel=Skirt;
		Skirt.addChild(Skirt211);
		setRotatePriorityYZX(Skirt211);

		Skirt212 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt212.addPlate(0F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt212.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	//	Skirt212.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt212.parentModel=Skirt;
		Skirt.addChild(Skirt212);
		setRotatePriorityYZX(Skirt212);

		Skirt213 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt213.addPlate(0F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt213.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	//	Skirt213.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt213.parentModel=Skirt;
		Skirt.addChild(Skirt213);
		setRotatePriorityYZX(Skirt213);

		Skirt214 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt214.addPlate(0F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt214.setRotationPointLM(0F, 2.0F-pyoffset, 0F);
	///	Skirt214.setPreRotationPointLM(0F,2F-f1,0F);
	//	Skirt214.parentModel=Skirt;
		Skirt.addChild(Skirt214);
		setRotatePriorityYZX(Skirt214);

		Skirt215 = new MMM_ModelRenderer_EX(this, 0, 32, 0.22F, 0.22F, 1.0F);
		Skirt215.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,psize);
		Skirt215.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt215.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt215.parentModel=Skirt;
		Skirt.addChild(Skirt215);
		setRotatePriorityYZX(Skirt215);

		Skirt216 = new MMM_ModelRenderer_EX(this, 0, 44, 0.22F, 0.22F, 1.0F);
		Skirt216.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,psize);
		Skirt216.setRotationPointLM(0F, 2.5F-pyoffset, 0F);
	//	Skirt216.setPreRotationPointLM(0F,2.5F-f1,0F);
	//	Skirt216.parentModel=Skirt;
		Skirt.addChild(Skirt216);
		setRotatePriorityYZX(Skirt216);

		Band1 = new MMM_ModelRenderer_EX(this, 0, 56,0.9F,0.35F,0.9F);
		Band1.addBox(-3F, 0F, -2F, 6, 4, 4,psize);
		Band1.setRotationPointLM(0F, -0.5F, 0F);
	//	Band1.setPreRotationPointLM(0F,4.7F-f1,0F);
		setRotationDeg(Band1,0F,0F,0F);
	//	Band1.parentModel=Skirt;

		EarL1 = new MMM_ModelRenderer_EX(this, 0, 16,0.25F,0.25F,1.0F);
		EarL1.addPlate(0F, 0F, 0F, 16, 16, 0,psize);
	//	EarL1.setRotationPointLM(0F, 0F+f1, 0F);
		EarL1.setRotationPointLM(3.0F-Scale,-6.5F,-0.4F);
		setRotationDeg(EarL1,8F,80F,-40F);
	//	EarL1.parentModel=bipedHead;
		bipedHead.addChild(EarL1);
		setRotatePriorityYZX(EarL1);

		EarL2 = new MMM_ModelRenderer_EX(this, 0, 16,0.25F,0.25F,1.0F);
		EarL2.mirror=true;
		EarL2.addPlate(-16F, 0F, 0F, 16, 16, 0,psize);
	//	EarL2.setRotationPointLM(0F, 0F+f1, 0F);
		EarL2.setRotationPointLM(3.0F-Scale,-6.5F,-0.4F);
		setRotationDeg(EarL2,60F,-100F,40F);
	//	EarL2.parentModel=bipedHead;
		bipedHead.addChild(EarL2);
		setRotatePriorityYZX(EarL2);

		EarR1 = new MMM_ModelRenderer_EX(this, 0, 16,0.25F,0.25F,1.0F);
		EarR1.addPlate(0F, 0F, 0F, 16, 16, 0,psize);
	//	EarR1.setRotationPointLM(0F, 0F+f1, 0F);
		EarR1.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.4F);
		setRotationDeg(EarR1,60F,100F,-40F);
	//	EarR1.parentModel=bipedHead;
		bipedHead.addChild(EarR1);
		setRotatePriorityYZX(EarR1);

		EarR2 = new MMM_ModelRenderer_EX(this, 0, 16,0.25F,0.25F,1.0F);
		EarR2.mirror=true;
		EarR2.addPlate(-16F, 0F, 0F, 16, 16, 0,psize);
	//	EarR2.setRotationPointLM(0F, 0F+f1, 0F);
		EarR2.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.4F);
		setRotationDeg(EarR2,8F,-80F,40F);
	//	EarR2.parentModel=bipedHead;
		bipedHead.addChild(EarR2);
		setRotatePriorityYZX(EarR2);

		EarLi1 = new MMM_ModelRenderer_EX(this, 16, 16,0.2F,0.2F,1.0F);
		EarLi1.addPlate(0F, 0F, 0F, 16, 16, 0,psize);
	//	EarLi1.setRotationPointLM(0F, 0F+f1, 0F);
		EarLi1.setRotationPointLM(3.0F-Scale,-6.5F,-0.5F);
		setRotationDeg(EarLi1,8F,80F,-40F);
	//	EarLi1.parentModel=bipedHead;
		bipedHead.addChild(EarLi1);
		setRotatePriorityYZX(EarLi1);

		EarLi2 = new MMM_ModelRenderer_EX(this, 16, 16,0.2F,0.2F,1.0F);
		EarLi2.mirror=true;
		EarLi2.addPlate(-16F, 0F, 0F, 16, 16, 0,psize);
	//	EarLi2.setRotationPointLM(0F, 0F+f1, 0F);
		EarLi2.setRotationPointLM(3.0F-Scale,-6.5F,-0.5F);
		setRotationDeg(EarLi2,60F,-100F,40F);
	//	EarLi2.parentModel=bipedHead;
		bipedHead.addChild(EarLi2);
		setRotatePriorityYZX(EarLi2);

		EarRi1 = new MMM_ModelRenderer_EX(this, 16, 16,0.2F,0.2F,1.0F);
		EarRi1.addPlate(0F, 0F, 0F, 16, 16, 0,psize);
	//	EarRi1.setRotationPointLM(0F, 0F+f1, 0F);
		EarRi1.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.5F);
		setRotationDeg(EarRi1,60F,100F,-40F);
	//	EarRi1.parentModel=bipedHead;
		bipedHead.addChild(EarRi1);
		setRotatePriorityYZX(EarRi1);

		EarRi2 = new MMM_ModelRenderer_EX(this, 16, 16,0.2F,0.2F,1.0F);
		EarRi2.mirror=true;
		EarRi2.addPlate(-16F, 0F, 0F, 16, 16, 0,psize);
	//	EarRi2.setRotationPointLM(0F, 0F+f1, 0F);
		EarRi2.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.5F);
		setRotationDeg(EarRi2,8F,-80F,40F);
	//	EarRi2.parentModel=bipedHead;
		bipedHead.addChild(EarRi2);
		setRotatePriorityYZX(EarRi2);

		Shippo1 = new MMM_ModelRenderer(this, 60, 16);
		Shippo1.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo1.setRotationPointLM(0F, 4.7F+Scale, 2F-Scale);
		setRotationDeg(Shippo1, 125F, 0F, 0F);
	//	Shippo1.parentModel=bipedBody;
		bipedBody.addChild(Shippo1);

		Shippo2 = new MMM_ModelRenderer(this, 60, 18);
		Shippo2.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo2.setRotationPointLM(0F, 1.7F, 0F);
		setRotationDeg(Shippo2, 20F, 0F, 0F);
		Shippo1.addChild(Shippo2);

		Shippo3 = new MMM_ModelRenderer(this, 60, 20);
		Shippo3.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo3.setRotationPointLM(0F, 1.7F, 0F);
		setRotationDeg(Shippo3, 10F, 0F, 0F);
		Shippo2.addChild(Shippo3);

		Shippo4 = new MMM_ModelRenderer(this, 60, 22);
		Shippo4.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo4.setRotationPointLM(0F, 1.8F, 0F);
		setRotationDeg(Shippo4, 5F, 0F, 0F);
		Shippo3.addChild(Shippo4);

		Shippo5 = new MMM_ModelRenderer(this, 60, 24);
		Shippo5.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo5.setRotationPointLM(0F, 1.8F, 0F);
		setRotationDeg(Shippo5, -5F, 0F, 0F);
		Shippo4.addChild(Shippo5);

		Shippo6 = new MMM_ModelRenderer(this, 60, 27);
		Shippo6.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
		Shippo6.setRotationPointLM(0F, 1.7F, 0F);
		setRotationDeg(Shippo6, -15F, 0F, 0F);
		Shippo5.addChild(Shippo6);


		setRotationDeg(Skirt21, -118F, 113F, 47F);
		setRotationDeg(Skirt22, -65F, 113F, 47F);
		setRotationDeg(Skirt23, -122F, 158F, 47F);
		setRotationDeg(Skirt24, -67F, 158F, 47F);
		setRotationDeg(Skirt25, -113F, -159F, 47F);
		setRotationDeg(Skirt26, -58F, -159F, 47F);
		setRotationDeg(Skirt27, -114F, -114F, 47F);
		setRotationDeg(Skirt28, -65F, -114F, 47F);
		setRotationDeg(Skirt29, -115F, -68F, 47F);
		setRotationDeg(Skirt210, -65F, -68F, 47F);
		setRotationDeg(Skirt211, -122F, -23F, 47F);
		setRotationDeg(Skirt212, -66F, -23F, 47F);
		setRotationDeg(Skirt213, -114F, 22F, 47F);
		setRotationDeg(Skirt214, -58F, 22F, 47F);
		setRotationDeg(Skirt215, -115F, 67F, 47F);
		setRotationDeg(Skirt216, -62F, 67F, 47F);

	}

	public void render(LMM_EntityLittleMaid entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
	//	System.out.println(String.format("Neko rotationPointY : %.2f",this.bipedBody.rotationPointY));
		super.renderLM(entity, f, f1, f2, f3, f4, f5);

	}

	public void setLivingAnimationsLM(LMM_EntityLittleMaid entityliving, float f, float f1, float f2)
	{
		super.setLivingAnimationsLM(entityliving, f, f1, f2);

		if (entityliving instanceof LMM_EntityLittleMaid) {
			LMM_EntityLittleMaid entitylittlemaid = (LMM_EntityLittleMaid)entityliving;
			float f3 = (float)entityliving.ticksExisted + f2 + entitylittlemaid.entityIdFactor;

			if( 0.0F > mh_sin(f3 * 0.05F) + mh_sin(f3 * 0.13F) + mh_sin(f3 * 0.7F) + 2.55F) {
				eyeR.showModel = eyeL.showModel = true;
			} else {
				eyeR.showModel = eyeL.showModel = false;
			}
			if( 0.0F > mh_sin(f3 * 0.17F) + mh_sin(f3 * 0.17F + 0.02F) + mh_sin(f3 * 0.11F) + mh_sin(f3 * 0.7F) + 3.10F) {
				EarL1.rotateAngleZ=EarR1.rotateAngleZ=EarLi1.rotateAngleZ=EarRi1.rotateAngleZ=-30F/180F*(float)Math.PI;
				EarL2.rotateAngleZ=EarR2.rotateAngleZ=EarLi2.rotateAngleZ=EarRi2.rotateAngleZ=30F/180F*(float)Math.PI;
				EarL1.rotateAngleY=EarLi1.rotateAngleY=90F/180F*(float)Math.PI;
				EarL2.rotateAngleY=EarLi2.rotateAngleY=-90F/180F*(float)Math.PI;
				EarR1.rotateAngleY=EarRi1.rotateAngleY=90F/180F*(float)Math.PI;
				EarR2.rotateAngleY=EarRi2.rotateAngleY=-90F/180F*(float)Math.PI;
			} else {
				EarL1.rotateAngleZ=EarR1.rotateAngleZ=EarLi1.rotateAngleZ=EarRi1.rotateAngleZ=-40F/180F*(float)Math.PI;
				EarL2.rotateAngleZ=EarR2.rotateAngleZ=EarLi2.rotateAngleZ=EarRi2.rotateAngleZ=40F/180F*(float)Math.PI;
				EarL1.rotateAngleY=EarLi1.rotateAngleY=80F/180F*(float)Math.PI;
				EarL2.rotateAngleY=EarLi2.rotateAngleY=-100F/180F*(float)Math.PI;
				EarR1.rotateAngleY=EarRi1.rotateAngleY=100F/180F*(float)Math.PI;
				EarR2.rotateAngleY=EarRi2.rotateAngleY=-80F/180F*(float)Math.PI;
			}
			IdOffset=entitylittlemaid.entityId;
		}
	}

	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, LMM_EntityLittleMaid pentitylittlemaid)
	{
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5,pentitylittlemaid);

		float t;
		if(isRiding)
			t=f2;
		else
			t=f2;

		Ahoge.rotateAngleY=MathHelper.cos(t * 0.2F + MathHelper.cos(t*0.05F+IdOffset) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX=2.9F;
		bipedHead.rotationPointZ=0F;
		bipedRightArm.rotationPointY =  9.5F + 4*Scale;
		bipedLeftArm.rotationPointY =  9.5F + 4*Scale;
		DrowaR2.rotationPointY=-0.7F;
		DrowaR2.rotationPointZ=0F;
		DrowaL2.rotationPointY=-0.7F;
		DrowaL2.rotationPointZ=0F;
		bipedBody.rotationPointY=9f;

		if(bipedHead.rotateAngleX>convertDegtoRad(10F))
			Tail2.rotateAngleX=Tail3.rotateAngleX=Tail4.rotateAngleX=Tail5.rotateAngleX=Tail6.rotateAngleX=-convertDegtoRad(10F);
		else
			Tail2.rotateAngleX=Tail3.rotateAngleX=Tail4.rotateAngleX=Tail5.rotateAngleX=Tail6.rotateAngleX=-bipedHead.rotateAngleX;//+bipedBody.rotateAngleX);
		Shippo1.rotateAngleX=125F/180F*(float)Math.PI+0.025F*MathHelper.sin(-t*0.6F+IdOffset);
		Shippo2.rotateAngleX=20F/180F*(float)Math.PI;
		Shippo3.rotateAngleX=10F/180F*(float)Math.PI;
		Shippo4.rotateAngleX=5F/180F*(float)Math.PI;
		Shippo5.rotateAngleX=-5F/180F*(float)Math.PI;
		Shippo6.rotateAngleX=-15F/180F*(float)Math.PI;
		Shippo1.rotateAngleY=0.2F*MathHelper.sin(t*0.3F+IdOffset);
		Shippo2.rotateAngleZ=0.2F*MathHelper.sin(-t*0.3F+0.00001F+IdOffset);
		Shippo3.rotateAngleZ=0.2F*MathHelper.sin(-t*0.3F+0.00002F+IdOffset);
		Shippo4.rotateAngleZ=0.2F*MathHelper.sin(-t*0.3F+0.00003F+IdOffset);
		Shippo5.rotateAngleZ=0.2F*MathHelper.sin(-t*0.3F+0.00004F+IdOffset);
		Shippo6.rotateAngleZ=0.2F*MathHelper.sin(-t*0.3F+0.00005F+IdOffset);

		if (onGround > -9990F && !aimedBow)
		{
			bipedRightArm.rotationPointZ = MathHelper.sin(bipedBody.rotateAngleY) * 4F;
			bipedRightArm.rotationPointX = -MathHelper.cos(bipedBody.rotateAngleY) * 4F + 1.0F+2.0F*Scale;
			bipedLeftArm.rotationPointZ = -MathHelper.sin(bipedBody.rotateAngleY) * 4F;
			bipedLeftArm.rotationPointX = MathHelper.cos(bipedBody.rotateAngleY) * 4F - 1.0F-2.0F*Scale;
			bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
			bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
			bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
		}

		if(isRiding)
		{
			Shippo1.rotateAngleX=125F/180F*(float)Math.PI+0.025F*MathHelper.sin(-t*0.4F+IdOffset);
			Shippo1.rotateAngleY=0.2F*MathHelper.sin(t*0.2F+IdOffset);
			Shippo2.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0002F+IdOffset);
			Shippo3.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0004F+IdOffset);
			Shippo4.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0006F+IdOffset);
			Shippo5.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0008F+IdOffset);
			Shippo6.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.001F+IdOffset);
		}
		if (aimedBow) {
			eyeL.showModel = true;
			Shippo1.rotateAngleX=145F/180F*(float)Math.PI;
			Shippo2.rotateAngleX=Shippo3.rotateAngleX=Shippo4.rotateAngleX=Shippo5.rotateAngleX=Shippo6.rotateAngleX=0;
			Shippo1.rotateAngleY=Shippo2.rotateAngleZ=Shippo3.rotateAngleZ=Shippo4.rotateAngleZ=Shippo5.rotateAngleZ=Shippo6.rotateAngleZ=0;
		}

		if(isSneak){
			Shippo1.rotateAngleX=125F/180F*(float)Math.PI+0.025F*MathHelper.sin(-t*0.4F+IdOffset);
			Shippo1.rotateAngleY=0.2F*MathHelper.sin(t*0.2F+IdOffset);
			Shippo2.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0002F+IdOffset);
			Shippo3.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0004F+IdOffset);
			Shippo4.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0006F+IdOffset);
			Shippo5.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.0008F+IdOffset);
			Shippo6.rotateAngleZ=0.2F*MathHelper.sin(-t*0.2F+0.001F+IdOffset);

			bipedBody.rotateAngleX = 0.5F;
			bipedBody.rotationPointZ = 0.0F;
			bipedBody.rotationPointY += 4.0F * Scale;
			bipedRightLeg.rotateAngleX -= 0.0F;
			bipedLeftLeg.rotateAngleX -= 0.0F;
			bipedRightArm.rotateAngleX += 0.4F;
			bipedLeftArm.rotateAngleX += 0.4F;
			bipedRightArm.rotationPointY =  10F + 6*Scale;
			bipedLeftArm.rotationPointY =  10F + 6*Scale;
			bipedRightArm.rotationPointZ = MathHelper.sin(bipedBody.rotateAngleY) * 4F+4*Scale;
			bipedLeftArm.rotationPointZ = -MathHelper.sin(bipedBody.rotateAngleY) * 4F+4*Scale;
			bipedRightLeg.rotationPointZ = 3.0F;
			bipedLeftLeg.rotationPointZ = 3.0F;
			bipedRightLeg.rotationPointY = 14.0F + Scale;
			bipedLeftLeg.rotationPointY = 14.0F + Scale;
			bipedHead.rotationPointY = 8.5F + 8.0F * Scale;
			bipedHead.rotationPointZ += 1F;
			bipedHeadwear.rotationPointY = 9.0F + 8.0F * Scale;
			bipedHeadwear.rotateAngleX += 0.5F;
			Skirt.rotationPointY = 13.8F + 6.0F * Scale;//14.9F
			Skirt.rotationPointZ = 3.0F;
			Skirt.rotateAngleX = 0.2F;
			Band1.rotationPointZ=-0.025F;
			DrowaR2.rotationPointY+=0.5F;
			DrowaL2.rotationPointY+=0.5F;
			DrowaR2.rotationPointZ=Skirt.rotationPointZ;
			DrowaL2.rotationPointZ=Skirt.rotationPointZ;
		}
		else
		{
			bipedBody.rotateAngleX = 0.0F;
			bipedBody.rotationPointZ = 0.0F;
			bipedBody.rotationPointY += 0.0F;
			bipedRightLeg.rotationPointZ = 0.0F;
			bipedLeftLeg.rotationPointZ = 0.0F;
			bipedRightLeg.rotationPointY = 15F + Scale;
			bipedLeftLeg.rotationPointY = 15F + Scale;
			bipedHead.rotationPointY = 8.0F + 5.0F * Scale;
			bipedHeadwear.rotationPointY = 8.0F + 5.0F * Scale;
			Skirt.rotationPointY = 15.0F + 2.0F * Scale;
			Skirt.rotationPointZ = 0.0F;
			if(isRiding)
			{
				Skirt.rotateAngleX = convertDegtoRad(-20F);
				Skirt.rotationPointZ = -0.8F;
				Skirt.rotationPointY -= 0.0F;
				DrowaR2.rotationPointY+=1.0F;
				DrowaL2.rotationPointY+=1.0F;
				DrowaR2.rotationPointZ=Skirt.rotationPointZ;
				DrowaL2.rotationPointZ=Skirt.rotationPointZ;
				Band1.rotateAngleX = convertDegtoRad(10F);
				bipedRightArm.rotationPointY =  9.5F + 2*Scale;
				bipedLeftArm.rotationPointY =  9.5F + 2*Scale;
			}
			else
			{
				Skirt.rotateAngleX = 0F;
				Band1.rotateAngleX = 0F;
			}
			Band1.rotationPointZ=-0.0F;
		}
		if (isWait)
        {
			bipedRightArm.rotationPointY =  9.5F + 2*Scale;
			bipedLeftArm.rotationPointY =  9.5F + 2*Scale;
        }
	}

	private void setRotatePriorityYZX(MMM_ModelRenderer model){
		model.rotatePriority=model.RotXZY;
	}

	private void setRotation(MMM_ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX=x;
		model.rotateAngleY=y;
		model.rotateAngleZ=z;
	}

	private void setRotationDeg(MMM_ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX=x*(float)Math.PI/180F;
		model.rotateAngleY=y*(float)Math.PI/180F;
		model.rotateAngleZ=z*(float)Math.PI/180F;
	}

	private float convertDegtoRad(float deg)
	{
		return deg/180F*(float)Math.PI;
	}

	@Override
	 public float getHeight()
	 {
		 return 1.25F;
	 }
	@Override
	 public float getWidth()
	 {
		 return 0.4F;
	 }
	@Override
	public void equippedHeadItemPosition()
    {
        GL11.glTranslatef(0.0F, 0.9F, 0.0F);
    }
}
