USE [SewTest]
GO
/****** Object:  Table [dbo].[__MigrationHistory]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[__MigrationHistory](
	[MigrationId] [nvarchar](150) NOT NULL,
	[ContextKey] [nvarchar](300) NOT NULL,
	[Model] [varbinary](max) NOT NULL,
	[ProductVersion] [nvarchar](32) NOT NULL,
 CONSTRAINT [PK_dbo.__MigrationHistory] PRIMARY KEY CLUSTERED 
(
	[MigrationId] ASC,
	[ContextKey] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[__MigrationHistory] ([MigrationId], [ContextKey], [Model], [ProductVersion]) VALUES (N'201508092302414_InitialCreate', N'SewServiceRepository.DAL.SewDBContext', 0x1F8B0800000000000400ED5DDB4EE4C819BE8F9477B0FA2A89666960B4D20635BB626088506040346CA2DC20D32E1A2B6EBBD77633A0284F968B3C525E21E553B9CE07BB6C778335D288AEC357A7FF507FD5EFFAFFF79FFFCE7E795D05CE0B88133F0A8F27077BFB1307848BC8F3C3E5F164933EFDF0D3E4979F7FFFBBD9576FF5EAFC5A95FB9C958335C3E478F29CA6EBA3E934593C83959BECADFC451C25D153BAB7885653D78BA687FBFB7F9E1E1C4C018498402CC799DD6EC2D45F81FC07FC791A850BB04E376E7015792048CA749833CF519D6FEE0A246B77018E2773F07D0EE2177F016EC13A4AFC348ADFF6CE4E2E27CE49E0BB495620789A386E1846A99BC2DE1EDD27609EC651B89CAF61821BDCBDAD012CF7E406092847715417D71DD0FE6136A0695DB1825A6C92345A19021E7C2E67684A576F34CF133483700EBFC2B94EDFB251E7F3783C39F1BC1824C9C4A1DB3A3A0DE2AC9C7896F772301F247B25C827875FF4B168F513A219485AD9BF4FCEE926483731380EC1268DDDE09373B3790CFCC55FC1DB5DF44F101E879B20C0FB0F4700F38804987413476B10A76FB7E0A91CD5853771A664BD295D1155C3EA1403BE08D3CF8713E71B6CDC7D0C00220F6C72E67064E02F2004B19B02EFC64D5310871906C887CAB44EB505691080B46A0FFE822C3671AEDCD74B102ED367C87CFB90A9CEFD57E05529651FEE431F7224AC94C61BC0E9A3BCDDD308325BFCA61EAA02261FA2B0F3F0CF2E3A3F87730FFA6FF61FFEFA14D61E66BC9BA4E54AC52023D0EBB08239833FEFA0B83546BA5F7B2224AAE237F7C55FE66CC2A7BE89730B823C3F79F6D78590AE44C8032A731E47ABDB28A8455495F5308F36F1225B8F889F7FE7C6CB8CB9F06ECDA6B5E493CA43D47E1B7958828CF250571E66FF0F210DA56C7DD049A33BC9D5DAEC03E15F7C0FC4EDF8A7421919C8120375A4A16E9EA3708066BFAE5C3FE8BFD9F30CB675A3F2364A5DD67A835608882F6FED604AE9C0C0BC430927DBB7201B89B36FA944D5032A546F5CE83C66E7C21468B575A9D0E6FE32DCAC6FC16F1B90A476043101394AE5EDDED68C52794BA5F287148C84E89049496E41A1C8E497B62F3F6D6D6529D05186EACAD0733F4E528520FDB113397AE90ED4F07D026245C387DD680E3749BE47B127D35987A3CA6ADBECD9F597D6D21B32546E66F7DDF751155A528572934150544F1DDA32284AFDD44E0196D9A3C2D3BE1B2A266910CD73069245ECAF8BBB4649DB7A8D2B147B14784A3DD7D5C155C936E339CB36C9D0FAF09823444BB678A80BD55293CE63C42453C0865C3C0329DC3EB4BC3A27B146296928255BEF430A98733F1846E05E4106C99AEC5F04FE0D3CDEDF5E767E7472BF0E22D7CB17F879802BF47A79B3A6C75D2B7F7E6402B7944C0FA8282376A91222E14B176B25823313B99DE0CD1046713B9EC288D96BA85318D5A94437C3D538FBE9FE38A4BF464FA3307517E9B7CDEA71886394422D0EA314E1CF27A8106FFC4526CA3ADF0190CDDD3DC3190FED1CBB6DE7095926376C6C366CD9A8A34BC1166EBC64C7851901F1CE06F17466934564F2B6568D0DEF1C9967751319FC0E49ED6D598F2A2612F7A82E41F5A8CAE0F708E5B6DE7E168DB7DD826665C76DA825878A210F45ED28AD9D1474466C73192DFD700EA5543E9D6DD907471BD948978DB2996B7F72964F7A3E5103D80C205BE52B777161C36079873CA952AE42C58A73D443519254B04C01AEA2654BB556B816FD1A19B851768C27415271B9ADFE385D7AC6201BA4EF0D9705FF98813C8A4E16A9FF92F399A56F06B7F38C633C0CB0B5473E499268E1E714431E0DA02F21C9D6BF869EA3F82CB2D481F547959022A0B2F2D7503DC11E1C4FFEC48C498C5A696D0C157D2249A21E30A850A98138D32A6E700AF719504DFA61CA6A403F5CF86B37907780AAA6A93AB379470DD03967609DB14F98CA2754A765ECBB6AB603A81D4AABABA66736C588434E3337F45728A2E5A50BF2A8A63EEBD1271B06974337026AB44437A21EF44038A249D5691A3B9D1D9472F86EFAAAE556F8ECB33445EDE1CD094CEEF7DF3BB549BBD323E949176267E9D040A0291D6615B4D84CDCA9DC6E87A5C74185A16241768126199743113988FD0FEBF547FE33FA5426F45AD450D696E84AD4851E084934A93A4DE377A743920EED3CA55869A127154346C8F7D4989A446E586A52B54B52827EF4475882C9D6E900E67C3A08751137C4A2F5E65F17D7AB5C9CEDEAD30FF786B93705C76BBD075AE14DE22EA82EF2D25EBAA432A5D58846065457DCF6FB22939D5454A42F85745D59C78A9684C2F8625080858745778442B7DF17A1D013A9D32EEE553618A1B07783B2F5955C1492EB4CBA04981191F89E51419D160949D8879E084A38D1BA84D513511527E0B9E7AD1F82186DA6BE9F7DC912C12BEF5617F6AFBCD84DCACB0A9A1C32D0394869CFBAFABC9DDEA030044522A0F36D0601E528106A2DC740D4599A18D4899910902AD7045DDA61A6A4A2056444308828470F01993A222054408157480106A548D6A85BA8236EFD224B038314755C2CB28806A68A42386528548C5F1946AA5FE4C44A911CC5BFAA72742EABD07830C6652491FA760A8311F1E8941CA4C60430972A9C19905FBCE85DBD609D174907BDBB16F564B69805C13B3EE229D1B8516870A7C0992C296D37B844E86F1AF5684BEB48BCD1A1B86A32350951750ADEC984B2DF83B333283FC0D53BC2C53A2F505C7A67B61A5CDE7C16988F348573213D9134399364E745A0874D0E21D593DD608EC8EF29D899119FA6A9CFD3B00EF3F611EA03B44E7883FA644330640DAEE01F10190FBA2766A0BE0B110C9B7FD8A171DC613C6CE67C8342E0EE1A9B0D9BE3B5CB1FBEC2843730E2A9C1C8B6AD0656BB629225D353795821FB12E5CDA645E89032613615C418995DB9EBB51F2EB19823658A332F028E9CFE30378FC1B12A30A60B42BAD0D6306A298D627709A8DCE2B1F2DCF7F6CC4DDD4737734C3BF5564C31C29A16D80E5553A4C1CCAE58654754E5B3BF91CDCEF7B01680D533790E07B7CA8E2F7237648EF4636A3A59E4173770638ED3F369146C56A1F820455CBB8AC081235469FA2898DF170E2471079360E5CED7040CC71D5B3EA63C400639A43C491F0345BBC05150A2595F32274DBA331BCEFE403227B59B26313175B23E16E6A8896361C92CD66C4A912D7348C6700925AE68A6D36249B13DDD802505601A2C29ACD90D4B162EF678FD22C5841D69CA1DC9B647B2956C281BD0AD084D8370C555B79572CBCF15708832491FA37C3704C72893F431F2D7B471843C41BF3E76EF8DA348AEC3C558D847061C2EFA62A41AB12F0D385C648635CA083CBFA18C200FEDAC0A0C29B481F450E08CA2448EB14DA26464593CDF06CBDAD6F20AF0A66CDBDF1E00FB2E9620FA3A591FABFED21587AA530DC80C7DBA4A50194A35102BE85B5442B2A0D4DD1350F967A638429EA05FBFFAF81287A8D24631B773624E7C23D240AC09C034C498B06647E760F86BE304DDE019064C853F964330179E612056B157C209B98AA51B881ECCDD92903F12374C31DA68A0BC5F31505D66DA9406024C7DA12004E85436D02092AF1F9458F543DB1CC43A531FB77E401B07AC53F591AA07B1719C2ACD84D2F1F7AE4962C7731ACD5CE5002C983B917FB0047B94144E634921B83D6D201F78481A52815F6D346F9A9837360C0A7B26525BD3847ADD98BC1121B24C259B48AE994AB51BEA11626A3746E43545C5DE1A16C36385FA36FDF06F3A68FA3597E576F7B6E341FEA8FD8A6C89F613B85135D4803C344D2DC8AFBAAD27F4B66DE4918EF1FC06744CF8AE59A36719AA265DCB21BAA1EFEA83305A2399DA7BF8F3B0A4C182E798700DF6E42BC93558C6C835BD714D0757B84A584DBE19E4EAF6BD9B48F6CC1BF27551C6E6127E0926466C6B30D9B893A2DFFE24F6CD545EDFA6C6B805DF5921CCF8B5D34550EB650AFA8DFCDA4B9F72C2D93D1F7FE6BA9E8F3B29FDDB6927F3A2C8C4A98C48B83A6F490A567B5981BDF96FC169E0C3F1D605AEDCD07F8242B778047B72B8BFFFD3C439097C37293E4228DDE78FE8EFBCB5FCE90F3E67FEF4C05B4DE9EAE65EF9194A9278C41BDDECBBE3FC47767A78C8DBCF2655F954B771FCC2C2C1BD68227C71E3C5B31B93F1DDB3D8BEC6B1B490BB3BD679E64BFE0B28B45E8F27FFCA6B1D39177F7F40153F39D731249E2367DFF9B779F3F9549063FAC3CA7DFD63A3F88EC00E147299B7D5AFFAC5E37C76DBBE779C49B3D4CA7BC73C24F6ED6AED97FEF9CF1EEF2AC7157B2CEBFCC61216053A929884C46EB8EEE1EF8AC69AC919E2D1FC76504410CB7650B9DFA80248E7B17C26109EAE9A4215DBA929FACDFC264CC6BC984F8198C7B3F918AC2E391078577CDF5AB78C22A04311F0E139EFDDE85C260A1297017F34E73F3AC8912D5C3A861117F7B081BCA04214F1055183E8B75B2987B0C8448D198F8CD9D3AE3FA33CEB4D9E71FDB277567E11DEDD76250D275CAA007ADF547DE34EDF56EC1D26C4B62EFFD435479B60473999EB4CBDEB0C6D4EC9A8623B4D407B70DB9529B53FB70DB6AFBCBA2D1814A453B795B35ED69FBB39537E24B6E6BC47BDABCC3C5A17B2AD7BDBCE8A4C96D626413B20CA31DB0624EE9A6D69BF4438665B10A03722676C0BD8362D2DDC27DB4CC1D6355B69D8C1F7AAE3F1F9C7D4A9AC6FF5CEEAD59ECDDD4642EBA39197D8C57967C9ACF29636D713ADAD30DCB5DACAEE06F7AD1EA9DB98BADFE3BDE3689D74624890AECF969594857B0B8B3732B437F496EDF5C7ADA6783CB6A4251B604C1A4C067B3F1C057829BA41066652C5F86242C9E884B0646390350A15267E885747EC3B2651C1C4CF70B34D491EABEE35F2B732A0A9C18AC9161E79FFE1387562274B6FB21E96E26FEF449852AE9348DF8440C50FE2500555E2BD9088EA4BBB1DA197FE45071324494533EF49B0A85FEADC3EBA9107826AAA1C64A482C217613828AD13523012FC7642A8EF4688639DC857CD564E830050502C160D6575420E264B64871AC4CFDBB12D4ADE90EB2FEC754F5AA388638461E805CBDE767D2078B46CFB84BF24D8591792BFCFE5EE53E66BAFF7E0025F3FA63DEE536418767E980597BC9334DC82EF606C7AE57AA9169C0C7747819905B46F4C0843C497DF8D98F26CB03C7A2DC930DA1A41E38B97108E27DE6304D7BB38EEB418519E076F35DC3CAF813A57B38586C1E8656DF71EB75EBB337682DCF39A43997AF0C85010B5820A481A1344E7E54694170491E7E373C374F2500BBDCA452EB244E845AE460BA4DCE5B6441611B5280B66CA6D59C5189C32A2B6E50CC18D004B5F9D7062BF4A6F571CEEFD0AF6A6964012F1AD25AC9EFDF8E93A01D33582391B7456602560158562D4529878E320F13D4C0097E025E1B33A9A1A3D82D03A2EEE6E7A04E4A252368DA3C14B437FCB8F429B133BFF0C0DAB28527ADB18F45EA7E3D2D33EB6BA48FF0E16CFBE2989E31B842671BAA5C39251AE6ED0FAE664DBE9D06C05A6C7B751D250F2BD0DADB3E0F3CA0E2BCC72D96BBAFA4337082CCF3EB4074D5BB875F25785F30B34AF1328F511C40C6286604118B5A8CC45F81455B635D5A3AA08E5A37305658C072DDE9338F59FDC450AB317D970C3E5C4F9D50D3620F3327B04DE4578BD49D79B140E19AC1E03625F97D9E8B2F66753A6CFB3EBDCFD39B13104D84D3FF32CBA0EBF6CFCC043FD3E677D94441099F15FBA3B666B99666E8FCB3784F48D79D65304544E1F3AB3B803AB7500C192EB70EEBE80267D8364780996EEE2AD96472210F54290D33E3BF3DD65ECAE9212A3AE0F7F421AF656AF3FFF1F23201537E6E50000, N'6.1.3-40302')
/****** Object:  Table [dbo].[UserType]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserType](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.UserType] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[UserType] ON
INSERT [dbo].[UserType] ([Id], [Name], [Description], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, N'Super Admin', N'Will be added later', 1, CAST(0x0000A4EF014A5592 AS DateTime), CAST(0x0000A4EF014A5592 AS DateTime))
INSERT [dbo].[UserType] ([Id], [Name], [Description], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, N'Company Admin', N'Will be added later', 1, CAST(0x0000A4EF014A5592 AS DateTime), CAST(0x0000A4EF014A5592 AS DateTime))
INSERT [dbo].[UserType] ([Id], [Name], [Description], [Status], [CreatedOn], [UpdatedOn]) VALUES (3, N'Company User', N'Will be added later', 1, CAST(0x0000A4EF014A5592 AS DateTime), CAST(0x0000A4EF014A5592 AS DateTime))
INSERT [dbo].[UserType] ([Id], [Name], [Description], [Status], [CreatedOn], [UpdatedOn]) VALUES (4, N'Individual User', N'Will be added later', 1, CAST(0x0000A4EF014A5592 AS DateTime), CAST(0x0000A4EF014A5592 AS DateTime))
SET IDENTITY_INSERT [dbo].[UserType] OFF
/****** Object:  Table [dbo].[UserSignupRequest]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserSignupRequest](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[UserName] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](max) NOT NULL,
	[EmailAddress] [nvarchar](50) NOT NULL,
	[DOB] [datetime] NOT NULL,
	[Phone] [nvarchar](max) NOT NULL,
	[ActivationCode] [nvarchar](max) NULL,
	[Gender] [nvarchar](max) NOT NULL,
	[CreatedBy] [int] NOT NULL,
	[UpdatedBy] [int] NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.UserSignupRequest] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Country]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Country](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Code] [nvarchar](10) NOT NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.Country] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Country] ON
INSERT [dbo].[Country] ([Id], [Name], [Code], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, N'Bangladesh', N'BD', 1, CAST(0x0000A4EF014A556A AS DateTime), CAST(0x0000A4EF014A556A AS DateTime))
INSERT [dbo].[Country] ([Id], [Name], [Code], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, N'Canada', N'CA', 1, CAST(0x0000A4EF014A556A AS DateTime), CAST(0x0000A4EF014A556A AS DateTime))
INSERT [dbo].[Country] ([Id], [Name], [Code], [Status], [CreatedOn], [UpdatedOn]) VALUES (3, N'USA', N'US', 1, CAST(0x0000A4EF014A556A AS DateTime), CAST(0x0000A4EF014A556A AS DateTime))
SET IDENTITY_INSERT [dbo].[Country] OFF
/****** Object:  Table [dbo].[Address]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Address](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Street] [nvarchar](100) NOT NULL,
	[CountryId] [int] NOT NULL,
	[City] [nvarchar](max) NOT NULL,
	[State] [nvarchar](max) NOT NULL,
	[ZipCode] [nvarchar](max) NOT NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.Address] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Address] ON
INSERT [dbo].[Address] ([Id], [Street], [CountryId], [City], [State], [ZipCode], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, N'Road-9,House-15,Shekertech', 1, N'Dhaka', N'DH', N'1207', 1, CAST(0x0000A4EF014A5583 AS DateTime), CAST(0x0000A4EF014A5583 AS DateTime))
INSERT [dbo].[Address] ([Id], [Street], [CountryId], [City], [State], [ZipCode], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, N'12 Maclellan Street', 2, N'Antigonish', N'NS', N'B2G1V5', 1, CAST(0x0000A4EF014A5583 AS DateTime), CAST(0x0000A4EF014A5583 AS DateTime))
INSERT [dbo].[Address] ([Id], [Street], [CountryId], [City], [State], [ZipCode], [Status], [CreatedOn], [UpdatedOn]) VALUES (3, N'15 James Street', 3, N'MiddlesBorough', N'WDC', N'B2Z1V5', 1, CAST(0x0000A4EF014A5583 AS DateTime), CAST(0x0000A4EF014A5583 AS DateTime))
SET IDENTITY_INSERT [dbo].[Address] OFF
/****** Object:  Table [dbo].[ProviderSignupRequester]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProviderSignupRequester](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[UserName] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](12) NOT NULL,
	[Phone] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[DOB] [datetime] NOT NULL,
	[Gender] [nvarchar](max) NOT NULL,
	[AddressId] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.ProviderSignupRequester] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ProviderSignupRequester] ON
INSERT [dbo].[ProviderSignupRequester] ([Id], [FirstName], [LastName], [UserName], [Password], [Phone], [Email], [DOB], [Gender], [AddressId], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, N'Wendy', N'MacCaull', N'wendy', N'stfx12', N'902-872-1113', N'wendy@stfx.ca', CAST(0x0000A4F000D1A34D AS DateTime), N'Female', 1, 1, CAST(0x0000A4F000D1A34D AS DateTime), CAST(0x0000A4F000D1A34D AS DateTime))
INSERT [dbo].[ProviderSignupRequester] ([Id], [FirstName], [LastName], [UserName], [Password], [Phone], [Email], [DOB], [Gender], [AddressId], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, N'Rhandra', N'MacDonald', N'rhandra', N'stfx12', N'902-872-1113', N'rhandra@stfx.ca', CAST(0x0000A4F000D1A350 AS DateTime), N'Female', 1, 1, CAST(0x0000A4F000D1A350 AS DateTime), CAST(0x0000A4F000D1A350 AS DateTime))
INSERT [dbo].[ProviderSignupRequester] ([Id], [FirstName], [LastName], [UserName], [Password], [Phone], [Email], [DOB], [Gender], [AddressId], [Status], [CreatedOn], [UpdatedOn]) VALUES (3, N'Mostafijur', N'Rahman', N'Hira', N'stfx12', N'902-872-1113', N'x2013ici@stfx.ca', CAST(0x0000A4F000D1A356 AS DateTime), N'Male', 1, 1, CAST(0x0000A4F000D1A356 AS DateTime), CAST(0x0000A4F000D1A356 AS DateTime))
SET IDENTITY_INSERT [dbo].[ProviderSignupRequester] OFF
/****** Object:  Table [dbo].[ProviderSignupRequest]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProviderSignupRequest](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Phone] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[Fax] [nvarchar](max) NULL,
	[AddressId] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.ProviderSignupRequest] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ProviderSignupRequest] ON
INSERT [dbo].[ProviderSignupRequest] ([Id], [Name], [Phone], [Email], [Fax], [AddressId], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, N'Center for Logic and Information', N'9028721113', N'cli@stfx.ca', N'4828721113', 1, 1, CAST(0x0000A4F000D17665 AS DateTime), CAST(0x0000A4F000D17665 AS DateTime))
INSERT [dbo].[ProviderSignupRequest] ([Id], [Name], [Phone], [Email], [Fax], [AddressId], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, N'St. Francis Xavier University', N'9028721113', N'stfx@stfx.ca', N'4828723331', 1, 1, CAST(0x0000A4F000D17682 AS DateTime), CAST(0x0000A4F000D17682 AS DateTime))
SET IDENTITY_INSERT [dbo].[ProviderSignupRequest] OFF
/****** Object:  Table [dbo].[Provider]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Provider](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
	[Phone] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[Fax] [nvarchar](max) NULL,
	[AddressId] [int] NOT NULL,
	[CreatedBy] [int] NOT NULL,
	[UpdatedBy] [int] NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.Provider] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Provider] ON
INSERT [dbo].[Provider] ([Id], [Name], [Phone], [Email], [Fax], [AddressId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, N'Center for Logic and Information', N'902872113', N'cli@stfx.ca', N'4828721113', 1, 1, 1, 1, CAST(0x0000A4F000D1E23C AS DateTime), CAST(0x0000A4F000D1E23C AS DateTime))
INSERT [dbo].[Provider] ([Id], [Name], [Phone], [Email], [Fax], [AddressId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, N'St. Francis Xavier University', N'902872113', N'stfx@stfx.ca', N'4828721113', 1, 1, 1, 1, CAST(0x0000A4F000D1E261 AS DateTime), CAST(0x0000A4F000D1E261 AS DateTime))
SET IDENTITY_INSERT [dbo].[Provider] OFF
/****** Object:  Table [dbo].[Service]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ServiceName] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](500) NULL,
	[FolderName] [nvarchar](max) NOT NULL,
	[ProviderId] [int] NOT NULL,
	[CreatedBy] [int] NOT NULL,
	[UpdatedBy] [int] NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.Service] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Service] ON
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, N'Cef3 Service', N'Cef3 Service Description', N'http://test.biocomalert.com/docs/services/cef3/', 1, 1, 1, 1, CAST(0x0000A4F000D7B969 AS DateTime), CAST(0x0000A4F000D7B969 AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, N'Ambrox Service', N'Ambrox Service Description', N'http://test.biocomalert.com/docs/services/ambrox/', 2, 1, 1, 1, CAST(0x0000A4F000D809F3 AS DateTime), CAST(0x0000A4F000D809F3 AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (3, N'Gmax Service', N'Gmax Service Description', N'http://test.biocomalert.com/docs/services/gmax/', 1, 1, 1, 1, CAST(0x0000A4F000D8A232 AS DateTime), CAST(0x0000A4F000D8A232 AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (4, N'Napa Service', N'Napa Service Description', N'http://test.biocomalert.com/docs/services/napa/', 2, 1, 1, 1, CAST(0x0000A4F000D8DDED AS DateTime), CAST(0x0000A4F000D8DDED AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (5, N'Serape Service', N'Serape Service Description', N'http://test.biocomalert.com/docs/services/serape/', 1, 1, 1, 1, CAST(0x0000A4F000D92DCD AS DateTime), CAST(0x0000A4F000D92DCD AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (6, N'Discover Patient Service', N'Discover Patient Service Description', N'http://test.biocomalert.com/docs/services/patient/', 2, 1, 1, 1, CAST(0x0000A4F000E3194B AS DateTime), CAST(0x0000A4F000E3194B AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (7, N'Discover Physician Service', N'Discover Physician Service Description', N'http://test.biocomalert.com/docs/services/physician/', 1, 1, 1, 1, CAST(0x0000A4F000EDBB14 AS DateTime), CAST(0x0000A4F000EDBB14 AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (8, N'Appointment Service', N'Appointment Service Description', N'http://test.biocomalert.com/docs/services/appoint/', 2, 1, 1, 1, CAST(0x0000A4F000F62F8B AS DateTime), CAST(0x0000A4F000F62F8B AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (9, N'Consult Service', N'Consult Service Description', N'http://test.biocomalert.com/docs/services/consult/', 1, 1, 1, 1, CAST(0x0000A4F000F7D32C AS DateTime), CAST(0x0000A4F000F7D32C AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (10, N'Explanation Service', N'Explanation Service Description', N'http://test.biocomalert.com/docs/services/explain/', 2, 1, 1, 1, CAST(0x0000A4F000F84818 AS DateTime), CAST(0x0000A4F000F84818 AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (11, N'Discover Caregiver Service', N'Discover Caregiver Service Description', N'http://test.biocomalert.com/docs/services/caregiver/', 1, 1, 1, 1, CAST(0x0000A4F000FDA666 AS DateTime), CAST(0x0000A4F000FDA666 AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (12, N'Delliver Care Service', N'Deliver Care Service Description', N'http://test.biocomalert.com/docs/services/delivercare/', 2, 1, 1, 1, CAST(0x0000A4F000FF83C2 AS DateTime), CAST(0x0000A4F000FF83C2 AS DateTime))
INSERT [dbo].[Service] ([Id], [ServiceName], [Description], [FolderName], [ProviderId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (13, N'Prescribe Drug Service', N'Prescribe Drug Service Description', N'http://test.biocomalert.com/docs/services/drug/', 1, 1, 1, 1, CAST(0x0000A4F00100FFA6 AS DateTime), CAST(0x0000A4F00100FFA6 AS DateTime))
SET IDENTITY_INSERT [dbo].[Service] OFF
/****** Object:  Table [dbo].[User]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[UserName] [nvarchar](20) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](max) NOT NULL,
	[DOB] [nvarchar](max) NOT NULL,
	[ContactNumber] [nvarchar](max) NOT NULL,
	[UploadPath] [nvarchar](max) NOT NULL,
	[ProfilePicture] [nvarchar](max) NULL,
	[ProfilePictureThumbnail] [nvarchar](max) NULL,
	[Gender] [nvarchar](max) NOT NULL,
	[UserTypeId] [int] NOT NULL,
	[ProviderId] [int] NOT NULL,
	[AddressId] [int] NOT NULL,
	[CreatedBy] [int] NOT NULL,
	[UpdatedBy] [int] NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.User] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[User] ON
INSERT [dbo].[User] ([Id], [FirstName], [LastName], [UserName], [Email], [Password], [DOB], [ContactNumber], [UploadPath], [ProfilePicture], [ProfilePictureThumbnail], [Gender], [UserTypeId], [ProviderId], [AddressId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (4, N'Wendy', N'MacCaull', N'wendy', N'wendy@stfx.ca', N'stfx12', N'Aug 10 2015 12:46PM', N'902-872-1113', N'N/A', NULL, NULL, N'Female', 1, 1, 1, 1, 1, 1, CAST(0x0000A4F000D28927 AS DateTime), CAST(0x0000A4F000D28927 AS DateTime))
INSERT [dbo].[User] ([Id], [FirstName], [LastName], [UserName], [Email], [Password], [DOB], [ContactNumber], [UploadPath], [ProfilePicture], [ProfilePictureThumbnail], [Gender], [UserTypeId], [ProviderId], [AddressId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (5, N'Rhandra', N'MacDonald', N'rhandra', N'rhandra@stfx.ca', N'stfx12', N'Aug 10 2015 12:46PM', N'902-872-1113', N'N/A', NULL, NULL, N'Female', 1, 1, 1, 1, 1, 1, CAST(0x0000A4F000D2892B AS DateTime), CAST(0x0000A4F000D2892B AS DateTime))
INSERT [dbo].[User] ([Id], [FirstName], [LastName], [UserName], [Email], [Password], [DOB], [ContactNumber], [UploadPath], [ProfilePicture], [ProfilePictureThumbnail], [Gender], [UserTypeId], [ProviderId], [AddressId], [CreatedBy], [UpdatedBy], [Status], [CreatedOn], [UpdatedOn]) VALUES (6, N'Mostafijur', N'Rahman', N'Hira', N'x2013ici@stfx.ca', N'stfx12', N'Aug 10 2015 12:46PM', N'902-872-1113', N'N/A', NULL, NULL, N'Female', 1, 1, 1, 1, 1, 1, CAST(0x0000A4F000D2892C AS DateTime), CAST(0x0000A4F000D2892C AS DateTime))
SET IDENTITY_INSERT [dbo].[User] OFF
/****** Object:  Table [dbo].[UserLoginSession]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserLoginSession](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
	[SessionToken] [nvarchar](max) NOT NULL,
	[DeviceMacId] [nvarchar](max) NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.UserLoginSession] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[UserLoginSession] ON
INSERT [dbo].[UserLoginSession] ([Id], [UserId], [SessionToken], [DeviceMacId], [Status], [CreatedOn], [UpdatedOn]) VALUES (4, 4, N'NAA2ADMANQA3ADQAOQA4ADIAOQAyADIANgA0ADYAMwAwADMANgA=', NULL, 1, CAST(0x0000A4F000D2D9E4 AS DateTime), CAST(0x0000A4F200DE1E83 AS DateTime))
INSERT [dbo].[UserLoginSession] ([Id], [UserId], [SessionToken], [DeviceMacId], [Status], [CreatedOn], [UpdatedOn]) VALUES (6, 6, N'MQAAAwAA==', NULL, 1, CAST(0x0000A4F000D2DA3F AS DateTime), CAST(0x0000A4F000D2DA3F AS DateTime))
SET IDENTITY_INSERT [dbo].[UserLoginSession] OFF
/****** Object:  Table [dbo].[ServiceDetails]    Script Date: 08/28/2015 03:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ServiceDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ServiceId] [int] NOT NULL,
	[ServiceFileName] [nvarchar](50) NOT NULL,
	[MimeType] [nvarchar](max) NOT NULL,
	[WebURL] [nvarchar](max) NULL,
	[UploadedPath] [nvarchar](max) NOT NULL,
	[ServiceFileTypeId] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[CreatedOn] [datetime] NOT NULL,
	[UpdatedOn] [datetime] NULL,
 CONSTRAINT [PK_dbo.ServiceDetails] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ServiceDetails] ON
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (1, 1, N'Cef3Service.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl', N'http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl', 1, 1, CAST(0x0000A4F00102265B AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (2, 1, N'Cef3Profile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl', N'http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl', 2, 1, CAST(0x0000A4F001022661 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (3, 1, N'Cef3QoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/cef3/Cef3QoSProfile.owl', N'http://test.biocomalert.com/docs/services/cef3/Cef3QoSProfile.owl', 3, 1, CAST(0x0000A4F001022670 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (4, 1, N'Cef3Process.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl', N'http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl', 4, 1, CAST(0x0000A4F001022672 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (5, 1, N'Cef3Grounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl', N'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl', 5, 1, CAST(0x0000A4F00102269B AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (6, 1, N'Cef3Grounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl', N'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl', 6, 1, CAST(0x0000A4F00102269C AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (7, 2, N'AmbroxService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl', 1, 1, CAST(0x0000A4F001023182 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (8, 2, N'AmbroxProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl', 2, 1, CAST(0x0000A4F001023188 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (9, 2, N'AmbroxQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxQoSProfile.owl', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxQoSProfile.owl', 3, 1, CAST(0x0000A4F001023189 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (10, 2, N'AmbroxProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl', 4, 1, CAST(0x0000A4F001023189 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (11, 2, N'AmbroxGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl', 5, 1, CAST(0x0000A4F001023189 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (12, 2, N'AmbroxGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl', N'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl', 6, 1, CAST(0x0000A4F00102318A AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (13, 3, N'GmaxService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/gmax/GmaxService.owl', N'http://test.biocomalert.com/docs/services/gmax/GmaxService.owl', 1, 1, CAST(0x0000A4F001023C57 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (14, 3, N'GmaxProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl', N'http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl', 2, 1, CAST(0x0000A4F001023C5D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (15, 3, N'GmaxQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/gmax/GmaxQoSProfile.owl', N'http://test.biocomalert.com/docs/services/gmax/GmaxQoSProfile.owl', 3, 1, CAST(0x0000A4F001023C5D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (16, 3, N'GmaxProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl', N'http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl', 4, 1, CAST(0x0000A4F001023C5D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (17, 3, N'GmaxGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl', N'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl', 5, 1, CAST(0x0000A4F001023C5E AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (18, 3, N'GmaxGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl', N'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl', 6, 1, CAST(0x0000A4F001023C5E AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (19, 4, N'NapaService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/napa/NapaService.owl', N'http://test.biocomalert.com/docs/services/napa/NapaService.owl', 1, 1, CAST(0x0000A4F001024933 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (20, 4, N'NapaProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/napa/NapaProfile.owl', N'http://test.biocomalert.com/docs/services/napa/NapaProfile.owl', 2, 1, CAST(0x0000A4F00102493A AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (21, 4, N'NapaQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/napa/NapaQoSProfile.owl', N'http://test.biocomalert.com/docs/services/napa/NapaQoSProfile.owl', 3, 1, CAST(0x0000A4F00102493C AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (22, 4, N'NapaProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/napa/NapaProcess.owl', N'http://test.biocomalert.com/docs/services/napa/NapaProcess.owl', 4, 1, CAST(0x0000A4F00102493C AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (23, 4, N'NapaGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl', N'http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl', 5, 1, CAST(0x0000A4F00102493D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (24, 4, N'NapaGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl', N'http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl', 6, 1, CAST(0x0000A4F00102493D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (25, 5, N'SerapeService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/serape/SerapeService.owl', N'http://test.biocomalert.com/docs/services/serape/SerapeService.owl', 1, 1, CAST(0x0000A4F00102538B AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (26, 5, N'SerapeProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl', N'http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl', 2, 1, CAST(0x0000A4F001025390 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (27, 5, N'SerapeQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/serape/SerapeQoSProfile.owl', N'http://test.biocomalert.com/docs/services/serape/SerapeQoSProfile.owl', 3, 1, CAST(0x0000A4F001025393 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (28, 5, N'SerapeProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl', N'http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl', 4, 1, CAST(0x0000A4F001025394 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (29, 5, N'SerapeGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl', N'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl', 5, 1, CAST(0x0000A4F001025394 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (30, 5, N'SerapeGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl', N'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl', 6, 1, CAST(0x0000A4F001025394 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (31, 6, N'DiscoverPatientService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl', 1, 1, CAST(0x0000A4F001025EC2 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (32, 6, N'DiscoverPatientProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProfile.owl', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProfile.owl', 2, 1, CAST(0x0000A4F001025EC6 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (33, 6, N'DiscoverPatientQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientQoSProfile.owl', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientQoSProfile.owl', 3, 1, CAST(0x0000A4F001025ECB AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (34, 6, N'DiscoverPatientProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProcess.owl', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProcess.owl', 4, 1, CAST(0x0000A4F001025ECC AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (35, 6, N'DiscoverPatientGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.owl', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.owl', 5, 1, CAST(0x0000A4F001025ED1 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (36, 6, N'DiscoverPatientGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.wsdl', N'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.wsdl', 6, 1, CAST(0x0000A4F001025ED2 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (37, 7, N'DiscoverPhysicianService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl', 1, 1, CAST(0x0000A4F001026A7D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (38, 7, N'DiscoverPhysicianProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProfile.owl', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProfile.owl', 2, 1, CAST(0x0000A4F001026A81 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (39, 7, N'DiscoverPhysicianQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianQoSProfile.owl', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianQoSProfile.owl', 3, 1, CAST(0x0000A4F001026A87 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (40, 7, N'DiscoverPhysicianProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProcess.owl', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProcess.owl', 4, 1, CAST(0x0000A4F001026A87 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (41, 7, N'DiscoverPhysicianGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.owl', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.owl', 5, 1, CAST(0x0000A4F001026A88 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (42, 7, N'DiscoverPhysicianGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.wsdl', N'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.wsdl', 6, 1, CAST(0x0000A4F001026A88 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (43, 8, N'AppointService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/appoint/AppointService.owl', N'http://test.biocomalert.com/docs/services/appoint/AppointService.owl', 1, 1, CAST(0x0000A4F0010276D7 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (44, 8, N'AppointProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/appoint/AppointProfile.owl', N'http://test.biocomalert.com/docs/services/appoint/AppointProfile.owl', 2, 1, CAST(0x0000A4F0010276DF AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (45, 8, N'AppointQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/appoint/AppointQoSProfile.owl', N'http://test.biocomalert.com/docs/services/appoint/AppointQoSProfile.owl', 3, 1, CAST(0x0000A4F0010276E2 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (46, 8, N'AppointProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/appoint/AppointProcess.owl', N'http://test.biocomalert.com/docs/services/appoint/AppointProcess.owl', 4, 1, CAST(0x0000A4F0010276E3 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (47, 8, N'AppointGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.owl', N'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.owl', 5, 1, CAST(0x0000A4F0010276E3 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (48, 8, N'AppointGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.wsdl', N'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.wsdl', 6, 1, CAST(0x0000A4F0010276E3 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (49, 9, N'ConsultService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/consult/ConsultService.owl', N'http://test.biocomalert.com/docs/services/consult/ConsultService.owl', 1, 1, CAST(0x0000A4F001028335 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (50, 9, N'ConsultProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/consult/ConsultProfile.owl', N'http://test.biocomalert.com/docs/services/consult/ConsultProfile.owl', 2, 1, CAST(0x0000A4F00102838D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (51, 9, N'ConsultQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/consult/ConsultQoSProfile.owl', N'http://test.biocomalert.com/docs/services/consult/ConsultQoSProfile.owl', 3, 1, CAST(0x0000A4F00102838E AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (52, 9, N'ConsultProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/consult/ConsultProcess.owl', N'http://test.biocomalert.com/docs/services/consult/ConsultProcess.owl', 4, 1, CAST(0x0000A4F00102838E AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (53, 9, N'ConsultGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.owl', N'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.owl', 5, 1, CAST(0x0000A4F00102838F AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (54, 9, N'ConsultGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.wsdl', N'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.wsdl', 6, 1, CAST(0x0000A4F001028390 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (55, 10, N'ExplainService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/explain/ExplainService.owl', N'http://test.biocomalert.com/docs/services/explain/ExplainService.owl', 1, 1, CAST(0x0000A4F001028FD3 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (56, 10, N'ExplainProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/explain/ExplainProfile.owl', N'http://test.biocomalert.com/docs/services/explain/ExplainProfile.owl', 2, 1, CAST(0x0000A4F001028FF7 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (57, 10, N'ExplainQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/explain/ExplainQoSProfile.owl', N'http://test.biocomalert.com/docs/services/explain/ExplainQoSProfile.owl', 3, 1, CAST(0x0000A4F001028FF8 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (58, 10, N'ExplainProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/explain/ExplainProcess.owl', N'http://test.biocomalert.com/docs/services/explain/ExplainProcess.owl', 4, 1, CAST(0x0000A4F001028FF8 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (59, 10, N'ExplainGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.owl', N'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.owl', 5, 1, CAST(0x0000A4F001028FF8 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (60, 10, N'ExplainGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.wsdl', N'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.wsdl', 6, 1, CAST(0x0000A4F001028FF9 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (61, 11, N'CareGiverService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl', 1, 1, CAST(0x0000A4F001029D01 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (62, 11, N'CareGiverProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl', 2, 1, CAST(0x0000A4F001029E7C AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (63, 11, N'CareGiverQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverQoSProfile.owl', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverQoSProfile.owl', 3, 1, CAST(0x0000A4F001029E82 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (64, 11, N'CareGiverProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverProcess.owl', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverProcess.owl', 4, 1, CAST(0x0000A4F001029E86 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (65, 11, N'CareGiverGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.owl', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.owl', 5, 1, CAST(0x0000A4F001029EC7 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (66, 11, N'CareGiverGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.wsdl', N'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.wsdl', 6, 1, CAST(0x0000A4F001029EC9 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (67, 12, N'DeliverCareService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl', 1, 1, CAST(0x0000A4F00102AD01 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (68, 12, N'DeliverCareProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProfile.owl', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProfile.owl', 2, 1, CAST(0x0000A4F00102AD76 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (69, 12, N'DeliverCareQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareQoSProfile.owl', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareQoSProfile.owl', 3, 1, CAST(0x0000A4F00102AD79 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (70, 12, N'DeliverCareProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProcess.owl', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProcess.owl', 4, 1, CAST(0x0000A4F00102AD7C AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (71, 12, N'DeliverCareGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.owl', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.owl', 5, 1, CAST(0x0000A4F00102AD7C AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (72, 12, N'DeliverCareGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.wsdl', N'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.wsdl', 6, 1, CAST(0x0000A4F00102AD7D AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (73, 13, N'PrescribeDrugService.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl', 1, 1, CAST(0x0000A4F00102B76F AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (74, 13, N'PrescribeDrugProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProfile.owl', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProfile.owl', 2, 1, CAST(0x0000A4F00102B773 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (75, 13, N'PrescribeDrugQoSProfile.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugQoSProfile.owl', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugQoSProfile.owl', 3, 1, CAST(0x0000A4F00102B777 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (76, 13, N'PrescribeDrugProcess.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProcess.owl', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProcess.owl', 4, 1, CAST(0x0000A4F00102B777 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (77, 13, N'PrescribeDrugGrounding.owl', N'application/rdf+xml', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.owl', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.owl', 5, 1, CAST(0x0000A4F00102B778 AS DateTime), NULL)
INSERT [dbo].[ServiceDetails] ([Id], [ServiceId], [ServiceFileName], [MimeType], [WebURL], [UploadedPath], [ServiceFileTypeId], [Status], [CreatedOn], [UpdatedOn]) VALUES (78, 13, N'PrescribeDrugGrounding.wsdl', N'application/wsdl+xml', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.wsdl', N'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.wsdl', 6, 1, CAST(0x0000A4F00102B778 AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[ServiceDetails] OFF
/****** Object:  ForeignKey [FK_dbo.Address_dbo.Country_CountryId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Address_dbo.Country_CountryId] FOREIGN KEY([CountryId])
REFERENCES [dbo].[Country] ([Id])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [FK_dbo.Address_dbo.Country_CountryId]
GO
/****** Object:  ForeignKey [FK_dbo.Provider_dbo.Address_AddressId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[Provider]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Provider_dbo.Address_AddressId] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Address] ([Id])
GO
ALTER TABLE [dbo].[Provider] CHECK CONSTRAINT [FK_dbo.Provider_dbo.Address_AddressId]
GO
/****** Object:  ForeignKey [FK_dbo.ProviderSignupRequest_dbo.Address_AddressId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[ProviderSignupRequest]  WITH CHECK ADD  CONSTRAINT [FK_dbo.ProviderSignupRequest_dbo.Address_AddressId] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Address] ([Id])
GO
ALTER TABLE [dbo].[ProviderSignupRequest] CHECK CONSTRAINT [FK_dbo.ProviderSignupRequest_dbo.Address_AddressId]
GO
/****** Object:  ForeignKey [FK_dbo.ProviderSignupRequester_dbo.Address_AddressId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[ProviderSignupRequester]  WITH CHECK ADD  CONSTRAINT [FK_dbo.ProviderSignupRequester_dbo.Address_AddressId] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Address] ([Id])
GO
ALTER TABLE [dbo].[ProviderSignupRequester] CHECK CONSTRAINT [FK_dbo.ProviderSignupRequester_dbo.Address_AddressId]
GO
/****** Object:  ForeignKey [FK_dbo.Service_dbo.Provider_ProviderId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[Service]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Service_dbo.Provider_ProviderId] FOREIGN KEY([ProviderId])
REFERENCES [dbo].[Provider] ([Id])
GO
ALTER TABLE [dbo].[Service] CHECK CONSTRAINT [FK_dbo.Service_dbo.Provider_ProviderId]
GO
/****** Object:  ForeignKey [FK_dbo.ServiceDetails_dbo.Service_ServiceId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[ServiceDetails]  WITH CHECK ADD  CONSTRAINT [FK_dbo.ServiceDetails_dbo.Service_ServiceId] FOREIGN KEY([ServiceId])
REFERENCES [dbo].[Service] ([Id])
GO
ALTER TABLE [dbo].[ServiceDetails] CHECK CONSTRAINT [FK_dbo.ServiceDetails_dbo.Service_ServiceId]
GO
/****** Object:  ForeignKey [FK_dbo.User_dbo.Address_AddressId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_dbo.User_dbo.Address_AddressId] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Address] ([Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_dbo.User_dbo.Address_AddressId]
GO
/****** Object:  ForeignKey [FK_dbo.User_dbo.Provider_ProviderId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_dbo.User_dbo.Provider_ProviderId] FOREIGN KEY([ProviderId])
REFERENCES [dbo].[Provider] ([Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_dbo.User_dbo.Provider_ProviderId]
GO
/****** Object:  ForeignKey [FK_dbo.User_dbo.UserType_UserTypeId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_dbo.User_dbo.UserType_UserTypeId] FOREIGN KEY([UserTypeId])
REFERENCES [dbo].[UserType] ([Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_dbo.User_dbo.UserType_UserTypeId]
GO
/****** Object:  ForeignKey [FK_dbo.UserLoginSession_dbo.User_UserId]    Script Date: 08/28/2015 03:29:10 ******/
ALTER TABLE [dbo].[UserLoginSession]  WITH CHECK ADD  CONSTRAINT [FK_dbo.UserLoginSession_dbo.User_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[UserLoginSession] CHECK CONSTRAINT [FK_dbo.UserLoginSession_dbo.User_UserId]
GO
