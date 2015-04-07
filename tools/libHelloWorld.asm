
libHelloWorld.so:     file format elf32-littlearm


Disassembly of section .dynsym:

00000114 <.dynsym>:
	...
 124:	00000001 	andeq	r0, r0, r1
	...
 130:	00000012 	andeq	r0, r0, r2, lsl r0
 134:	00000010 	andeq	r0, r0, r0, lsl r0
	...
 140:	00000012 	andeq	r0, r0, r2, lsl r0
 144:	0000001d 	andeq	r0, r0, sp, lsl r0
 148:	00000be5 	andeq	r0, r0, r5, ror #23
 14c:	00000004 	andeq	r0, r0, r4
 150:	00070012 	andeq	r0, r7, r2, lsl r0
 154:	0000006f 	andeq	r0, r0, pc, rrx
 158:	0000142c 	andeq	r1, r0, ip, lsr #8
 15c:	00000008 	andeq	r0, r0, r8
 160:	00070012 	andeq	r0, r7, r2, lsl r0
 164:	00000086 	andeq	r0, r0, r6, lsl #1
	...
 170:	00000022 	andeq	r0, r0, r2, lsr #32
 174:	0000009e 	muleq	r0, lr, r0
 178:	00001424 	andeq	r1, r0, r4, lsr #8
 17c:	00000008 	andeq	r0, r0, r8
 180:	00070022 	andeq	r0, r7, r2, lsr #32
 184:	000000b5 	strheq	r0, [r0], -r5
 188:	0000141c 	andeq	r1, r0, ip, lsl r4
 18c:	00000008 	andeq	r0, r0, r8
 190:	00070022 	andeq	r0, r7, r2, lsr #32
 194:	000000cc 	andeq	r0, r0, ip, asr #1
 198:	000019e8 	andeq	r1, r0, r8, ror #19
 19c:	00000000 	andeq	r0, r0, r0
 1a0:	00070012 	andeq	r0, r7, r2, lsl r0
 1a4:	000000e7 	andeq	r0, r0, r7, ror #1
 1a8:	000019d8 	ldrdeq	r1, [r0], -r8
 1ac:	00000000 	andeq	r0, r0, r0
 1b0:	00070012 	andeq	r0, r7, r2, lsl r0
 1b4:	00000100 	andeq	r0, r0, r0, lsl #2
 1b8:	000019f8 	strdeq	r1, [r0], -r8
 1bc:	00000000 	andeq	r0, r0, r0
 1c0:	00070012 	andeq	r0, r7, r2, lsl r0
 1c4:	00000124 	andeq	r0, r0, r4, lsr #2
 1c8:	00001a08 	andeq	r1, r0, r8, lsl #20
 1cc:	00000000 	andeq	r0, r0, r0
 1d0:	00070012 	andeq	r0, r7, r2, lsl r0
 1d4:	0000013f 	andeq	r0, r0, pc, lsr r1
 1d8:	00001a90 	muleq	r0, r0, sl
 1dc:	00000000 	andeq	r0, r0, r0
 1e0:	00070012 	andeq	r0, r7, r2, lsl r0
 1e4:	0000015a 	andeq	r0, r0, sl, asr r1
	...
 1f0:	00000012 	andeq	r0, r0, r2, lsl r0
 1f4:	00000161 	andeq	r0, r0, r1, ror #2
 1f8:	000019c4 	andeq	r1, r0, r4, asr #19
 1fc:	00000014 	andeq	r0, r0, r4, lsl r0
 200:	00070012 	andeq	r0, r7, r2, lsl r0
 204:	00000173 	andeq	r0, r0, r3, ror r1
	...
 210:	00000012 	andeq	r0, r0, r2, lsl r0
 214:	00000179 	andeq	r0, r0, r9, ror r1
 218:	00000fac 	andeq	r0, r0, ip, lsr #31
 21c:	00000044 	andeq	r0, r0, r4, asr #32
 220:	00070012 	andeq	r0, r7, r2, lsl r0
 224:	00000189 	andeq	r0, r0, r9, lsl #3
 228:	00001018 	andeq	r1, r0, r8, lsl r0
 22c:	00000044 	andeq	r0, r0, r4, asr #32
 230:	00070012 	andeq	r0, r7, r2, lsl r0
 234:	00000199 	muleq	r0, r9, r1
	...
 240:	00000020 	andeq	r0, r0, r0, lsr #32
 244:	000001ad 	andeq	r0, r0, sp, lsr #3
	...
 250:	00000020 	andeq	r0, r0, r0, lsr #32
 254:	000001be 			; <UNDEFINED> instruction: 0x000001be
 258:	00001bc4 	andeq	r1, r0, r4, asr #23
 25c:	00000394 	muleq	r0, r4, r3
 260:	00070012 	andeq	r0, r7, r2, lsl r0
 264:	000001d3 	ldrdeq	r0, [r0], -r3
	...
 270:	00000020 	andeq	r0, r0, r0, lsr #32
 274:	000001e9 	andeq	r0, r0, r9, ror #3
 278:	00001434 	andeq	r1, r0, r4, lsr r4
 27c:	00000358 	andeq	r0, r0, r8, asr r3
 280:	00070012 	andeq	r0, r7, r2, lsl r0
 284:	000001f9 	strdeq	r0, [r0], -r9
 288:	000019f0 	strdeq	r1, [r0], -r0
 28c:	00000000 	andeq	r0, r0, r0
 290:	00070012 	andeq	r0, r7, r2, lsl r0
 294:	00000211 	andeq	r0, r0, r1, lsl r2
 298:	000019e0 	andeq	r1, r0, r0, ror #19
 29c:	00000000 	andeq	r0, r0, r0
 2a0:	00070012 	andeq	r0, r7, r2, lsl r0
 2a4:	00000227 	andeq	r0, r0, r7, lsr #4
 2a8:	00001a00 	andeq	r1, r0, r0, lsl #20
 2ac:	00000000 	andeq	r0, r0, r0
 2b0:	00070012 	andeq	r0, r7, r2, lsl r0
 2b4:	00000248 	andeq	r0, r0, r8, asr #4
 2b8:	00001a4c 	andeq	r1, r0, ip, asr #20
 2bc:	00000000 	andeq	r0, r0, r0
 2c0:	00070012 	andeq	r0, r7, r2, lsl r0
 2c4:	00000260 	andeq	r0, r0, r0, ror #4
 2c8:	00001aa4 	andeq	r1, r0, r4, lsr #21
 2cc:	00000000 	andeq	r0, r0, r0
 2d0:	00070012 	andeq	r0, r7, r2, lsl r0
 2d4:	00000278 	andeq	r0, r0, r8, ror r2
 2d8:	0000178c 	andeq	r1, r0, ip, lsl #15
 2dc:	00000008 	andeq	r0, r0, r8
 2e0:	00070012 	andeq	r0, r7, r2, lsl r0
 2e4:	00000287 	andeq	r0, r0, r7, lsl #5
 2e8:	00001794 	muleq	r0, r4, r7
 2ec:	000000a4 	andeq	r0, r0, r4, lsr #1
 2f0:	00070012 	andeq	r0, r7, r2, lsl r0
 2f4:	000002a3 	andeq	r0, r0, r3, lsr #5
 2f8:	00001838 	andeq	r1, r0, r8, lsr r8
 2fc:	0000001c 	andeq	r0, r0, ip, lsl r0
 300:	00070012 	andeq	r0, r7, r2, lsl r0
 304:	000002bd 			; <UNDEFINED> instruction: 0x000002bd
 308:	00001854 	andeq	r1, r0, r4, asr r8
 30c:	0000006c 	andeq	r0, r0, ip, rrx
 310:	00070012 	andeq	r0, r7, r2, lsl r0
 314:	000002d1 	ldrdeq	r0, [r0], -r1
 318:	000018c0 	andeq	r1, r0, r0, asr #17
 31c:	00000020 	andeq	r0, r0, r0, lsr #32
 320:	00070012 	andeq	r0, r7, r2, lsl r0
 324:	000002f0 	strdeq	r0, [r0], -r0	; <UNPREDICTABLE>
 328:	000018e0 	andeq	r1, r0, r0, ror #17
 32c:	00000004 	andeq	r0, r0, r4
 330:	00070012 	andeq	r0, r7, r2, lsl r0
 334:	00000301 	andeq	r0, r0, r1, lsl #6
 338:	000018e4 	andeq	r1, r0, r4, ror #17
 33c:	00000020 	andeq	r0, r0, r0, lsr #32
 340:	00070012 	andeq	r0, r7, r2, lsl r0
 344:	00000319 	andeq	r0, r0, r9, lsl r3
 348:	00001904 	andeq	r1, r0, r4, lsl #18
 34c:	000000c0 	andeq	r0, r0, r0, asr #1
 350:	00070012 	andeq	r0, r7, r2, lsl r0
 354:	00000330 	andeq	r0, r0, r0, lsr r3
 358:	000019c4 	andeq	r1, r0, r4, asr #19
 35c:	00000014 	andeq	r0, r0, r4, lsl r0
 360:	00070012 	andeq	r0, r7, r2, lsl r0
 364:	00000344 	andeq	r0, r0, r4, asr #6
 368:	00001ab8 			; <UNDEFINED> instruction: 0x00001ab8
 36c:	00000024 	andeq	r0, r0, r4, lsr #32
 370:	00070012 	andeq	r0, r7, r2, lsl r0
 374:	0000035d 	andeq	r0, r0, sp, asr r3
 378:	00001ab8 			; <UNDEFINED> instruction: 0x00001ab8
 37c:	00000024 	andeq	r0, r0, r4, lsr #32
 380:	00070012 	andeq	r0, r7, r2, lsl r0
 384:	00000374 	andeq	r0, r0, r4, ror r3
 388:	00001adc 	ldrdeq	r1, [r0], -ip
 38c:	00000024 	andeq	r0, r0, r4, lsr #32
 390:	00070012 	andeq	r0, r7, r2, lsl r0
 394:	00000385 	andeq	r0, r0, r5, lsl #7
 398:	00001adc 	ldrdeq	r1, [r0], -ip
 39c:	00000024 	andeq	r0, r0, r4, lsr #32
 3a0:	00070012 	andeq	r0, r7, r2, lsl r0
 3a4:	00000394 	muleq	r0, r4, r3
 3a8:	00001b00 	andeq	r1, r0, r0, lsl #22
 3ac:	00000024 	andeq	r0, r0, r4, lsr #32
 3b0:	00070012 	andeq	r0, r7, r2, lsl r0
 3b4:	000003b0 			; <UNDEFINED> instruction: 0x000003b0
 3b8:	00001b00 	andeq	r1, r0, r0, lsl #22
 3bc:	00000024 	andeq	r0, r0, r4, lsr #32
 3c0:	00070012 	andeq	r0, r7, r2, lsl r0
 3c4:	000003ca 	andeq	r0, r0, sl, asr #7
 3c8:	00001b24 	andeq	r1, r0, r4, lsr #22
 3cc:	00000024 	andeq	r0, r0, r4, lsr #32
 3d0:	00070012 	andeq	r0, r7, r2, lsl r0
 3d4:	000003e1 	andeq	r0, r0, r1, ror #7
 3d8:	00001b24 	andeq	r1, r0, r4, lsr #22
 3dc:	00000024 	andeq	r0, r0, r4, lsr #32
 3e0:	00070012 	andeq	r0, r7, r2, lsl r0
 3e4:	000003f6 	strdeq	r0, [r0], -r6
 3e8:	00001b48 	andeq	r1, r0, r8, asr #22
 3ec:	00000024 	andeq	r0, r0, r4, lsr #32
 3f0:	00070012 	andeq	r0, r7, r2, lsl r0
 3f4:	0000040a 	andeq	r0, r0, sl, lsl #8
 3f8:	00001b48 	andeq	r1, r0, r8, asr #22
 3fc:	00000024 	andeq	r0, r0, r4, lsr #32
 400:	00070012 	andeq	r0, r7, r2, lsl r0
 404:	0000041c 	andeq	r0, r0, ip, lsl r4
 408:	00001f58 	andeq	r1, r0, r8, asr pc
 40c:	00000040 	andeq	r0, r0, r0, asr #32
 410:	00070012 	andeq	r0, r7, r2, lsl r0
 414:	0000042f 	andeq	r0, r0, pc, lsr #8
 418:	00001f98 	muleq	r0, r8, pc	; <UNPREDICTABLE>
 41c:	0000002c 	andeq	r0, r0, ip, lsr #32
 420:	00070012 	andeq	r0, r7, r2, lsl r0
 424:	00000446 	andeq	r0, r0, r6, asr #8
 428:	00001fc4 	andeq	r1, r0, r4, asr #31
 42c:	00000038 	andeq	r0, r0, r8, lsr r0
 430:	00070012 	andeq	r0, r7, r2, lsl r0
 434:	00000466 	andeq	r0, r0, r6, ror #8
 438:	00001ffc 	strdeq	r1, [r0], -ip
 43c:	00000008 	andeq	r0, r0, r8
 440:	00070012 	andeq	r0, r7, r2, lsl r0
 444:	0000047d 	andeq	r0, r0, sp, ror r4
 448:	00002004 	andeq	r2, r0, r4
 44c:	00000008 	andeq	r0, r0, r8
 450:	00070012 	andeq	r0, r7, r2, lsl r0
 454:	00000494 	muleq	r0, r4, r4
 458:	00004004 	andeq	r4, r0, r4
 45c:	00000000 	andeq	r0, r0, r0
 460:	fff10010 			; <UNDEFINED> instruction: 0xfff10010
 464:	0000049b 	muleq	r0, fp, r4
 468:	00004004 	andeq	r4, r0, r4
 46c:	00000000 	andeq	r0, r0, r0
 470:	fff10010 			; <UNDEFINED> instruction: 0xfff10010
 474:	000004a7 	andeq	r0, r0, r7, lsr #9
 478:	00004004 	andeq	r4, r0, r4
 47c:	00000000 	andeq	r0, r0, r0
 480:	fff10010 			; <UNDEFINED> instruction: 0xfff10010

Disassembly of section .dynstr:

00000484 <.dynstr>:
 484:	635f5f00 	cmpvs	pc, #0, 30
 488:	665f6178 			; <UNDEFINED> instruction: 0x665f6178
 48c:	6c616e69 	stclvs	14, cr6, [r1], #-420	; 0xfffffe5c
 490:	00657a69 	rsbeq	r7, r5, r9, ror #20
 494:	78635f5f 	stmdavc	r3!, {r0, r1, r2, r3, r4, r6, r8, r9, sl, fp, ip, lr}^
 498:	74615f61 	strbtvc	r5, [r1], #-3937	; 0xf61
 49c:	74697865 	strbtvc	r7, [r9], #-2149	; 0x865
 4a0:	355a5f00 	ldrbcc	r5, [sl, #-3840]	; 0xf00
 4a4:	76614a38 			; <UNDEFINED> instruction: 0x76614a38
 4a8:	6f635f61 	svcvs	0x00635f61
 4ac:	78655f6d 	stmdavc	r5!, {r0, r2, r3, r5, r6, r8, r9, sl, fp, ip, lr}^
 4b0:	6c706d61 	ldclvs	13, cr6, [r0], #-388	; 0xfffffe7c
 4b4:	796d5f65 	stmdbvc	sp!, {r0, r2, r5, r6, r8, r9, sl, fp, ip, lr}^
 4b8:	72646e61 	rsbvc	r6, r4, #1552	; 0x610
 4bc:	5f64696f 	svcpl	0x0064696f
 4c0:	6e69614d 	powvsem	f6, f1, #5.0
 4c4:	69746341 	ldmdbvs	r4!, {r0, r6, r8, r9, sp, lr}^
 4c8:	79746976 	ldmdbvc	r4!, {r1, r2, r4, r5, r6, r8, fp, sp, lr}^
 4cc:	6c65685f 	stclvs	8, cr6, [r5], #-380	; 0xfffffe84
 4d0:	57776f6c 	ldrbpl	r6, [r7, -ip, ror #30]!
 4d4:	646c726f 	strbtvs	r7, [ip], #-623	; 0x26f
 4d8:	6d6f7246 	sfmvs	f7, 2, [pc, #-280]!	; 3c8 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x81c>
 4dc:	50494e4a 	subpl	r4, r9, sl, asr #28
 4e0:	4e4a5f37 	mcrmi	15, 2, r5, cr10, cr7, {1}
 4e4:	766e4549 	strbtvc	r4, [lr], -r9, asr #10
 4e8:	6a5f3850 	bvs	17ce630 <__bss_start+0x17ca62c>
 4ec:	656a626f 	strbvs	r6, [sl, #-623]!	; 0x26f
 4f0:	5f007463 	svcpl	0x00007463
 4f4:	6165615f 	cmnvs	r5, pc, asr r1
 4f8:	755f6962 	ldrbvc	r6, [pc, #-2402]	; fffffb9e <__bss_start+0xffffbb9a>
 4fc:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 500:	70635f64 	rsbvc	r5, r3, r4, ror #30
 504:	72705f70 	rsbsvc	r5, r0, #112, 30	; 0x1c0
 508:	5f5f0030 	svcpl	0x005f0030
 50c:	5f756e67 	svcpl	0x00756e67
 510:	69776e55 	ldmdbvs	r7!, {r0, r2, r4, r6, r9, sl, fp, sp, lr}^
 514:	465f646e 	ldrbmi	r6, [pc], -lr, ror #8
 518:	5f646e69 	svcpl	0x00646e69
 51c:	64697865 	strbtvs	r7, [r9], #-2149	; 0x865
 520:	5f5f0078 	svcpl	0x005f0078
 524:	62616561 	rsbvs	r6, r1, #406847488	; 0x18400000
 528:	6e755f69 	cdpvs	15, 7, cr5, cr5, cr9, {3}
 52c:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 530:	7070635f 	rsbsvc	r6, r0, pc, asr r3
 534:	3172705f 	cmncc	r2, pc, asr r0
 538:	615f5f00 	cmpvs	pc, r0, lsl #30
 53c:	69626165 	stmdbvs	r2!, {r0, r2, r5, r6, r8, sp, lr}^
 540:	776e755f 			; <UNDEFINED> instruction: 0x776e755f
 544:	5f646e69 	svcpl	0x00646e69
 548:	5f707063 	svcpl	0x00707063
 54c:	00327270 	eorseq	r7, r2, r0, ror r2
 550:	6e675f5f 	mcrvs	15, 3, r5, cr7, cr15, {2}
 554:	6e555f75 	mrcvs	15, 2, r5, cr5, cr5, {3}
 558:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 55c:	7365525f 	cmnvc	r5, #-268435451	; 0xf0000005
 560:	65726f74 	ldrbvs	r6, [r2, #-3956]!	; 0xf74
 564:	5046565f 	subpl	r5, r6, pc, asr r6
 568:	5f00445f 	svcpl	0x0000445f
 56c:	756e675f 	strbvc	r6, [lr, #-1887]!	; 0x75f
 570:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 574:	5f646e69 	svcpl	0x00646e69
 578:	74736552 	ldrbtvc	r6, [r3], #-1362	; 0x552
 57c:	5f65726f 	svcpl	0x0065726f
 580:	00504656 	subseq	r4, r0, r6, asr r6
 584:	6e675f5f 	mcrvs	15, 3, r5, cr7, cr15, {2}
 588:	6e555f75 	mrcvs	15, 2, r5, cr5, cr5, {3}
 58c:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 590:	7365525f 	cmnvc	r5, #-268435451	; 0xf0000005
 594:	65726f74 	ldrbvs	r6, [r2, #-3956]!	; 0xf74
 598:	5046565f 	subpl	r5, r6, pc, asr r6
 59c:	315f445f 	cmpcc	pc, pc, asr r4	; <UNPREDICTABLE>
 5a0:	6f745f36 	svcvs	0x00745f36
 5a4:	0031335f 	eorseq	r3, r1, pc, asr r3
 5a8:	6e675f5f 	mcrvs	15, 3, r5, cr7, cr15, {2}
 5ac:	6e555f75 	mrcvs	15, 2, r5, cr5, cr5, {3}
 5b0:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 5b4:	7365525f 	cmnvc	r5, #-268435451	; 0xf0000005
 5b8:	65726f74 	ldrbvs	r6, [r2, #-3956]!	; 0xf74
 5bc:	4d4d575f 	stclmi	7, cr5, [sp, #-380]	; 0xfffffe84
 5c0:	5f004458 	svcpl	0x00004458
 5c4:	756e675f 	strbvc	r6, [lr, #-1887]!	; 0x75f
 5c8:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 5cc:	5f646e69 	svcpl	0x00646e69
 5d0:	74736552 	ldrbtvc	r6, [r3], #-1362	; 0x552
 5d4:	5f65726f 	svcpl	0x0065726f
 5d8:	584d4d57 	stmdapl	sp, {r0, r1, r2, r4, r6, r8, sl, fp, lr}^
 5dc:	656d0043 	strbvs	r0, [sp, #-67]!	; 0x43
 5e0:	7970636d 	ldmdbvc	r0!, {r0, r2, r3, r5, r6, r8, r9, sp, lr}^
 5e4:	73657200 	cmnvc	r5, #0, 4
 5e8:	65726f74 	ldrbvs	r6, [r2, #-3956]!	; 0xf74
 5ec:	726f635f 	rsbvc	r6, pc, #2080374785	; 0x7c000001
 5f0:	65725f65 	ldrbvs	r5, [r2, #-3941]!	; 0xf65
 5f4:	61007367 	tstvs	r0, r7, ror #6
 5f8:	74726f62 	ldrbtvc	r6, [r2], #-3938	; 0xf62
 5fc:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 600:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 604:	5352565f 	cmppl	r2, #99614720	; 0x5f00000
 608:	7465475f 	strbtvc	r4, [r5], #-1887	; 0x75f
 60c:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 610:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 614:	5352565f 	cmppl	r2, #99614720	; 0x5f00000
 618:	7465535f 	strbtvc	r5, [r5], #-863	; 0x35f
 61c:	635f5f00 	cmpvs	pc, #0, 30
 620:	625f6178 	subsvs	r6, pc, #120, 2
 624:	6e696765 	cdpvs	7, 6, cr6, cr9, cr5, {3}
 628:	656c635f 	strbvs	r6, [ip, #-863]!	; 0x35f
 62c:	70756e61 	rsbsvc	r6, r5, r1, ror #28
 630:	635f5f00 	cmpvs	pc, #0, 30
 634:	745f6178 	ldrbvc	r6, [pc], #-376	; 63c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x5a8>
 638:	5f657079 	svcpl	0x00657079
 63c:	6374616d 	cmnvs	r4, #1073741851	; 0x4000001b
 640:	5f5f0068 	svcpl	0x005f0068
 644:	5f756e67 	svcpl	0x00756e67
 648:	69776e75 	ldmdbvs	r7!, {r0, r2, r4, r5, r6, r9, sl, fp, sp, lr}^
 64c:	655f646e 	ldrbvs	r6, [pc, #-1134]	; 1e6 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x9fe>
 650:	75636578 	strbvc	r6, [r3, #-1400]!	; 0x578
 654:	5f006574 	svcpl	0x00006574
 658:	6178635f 	cmnvs	r8, pc, asr r3
 65c:	6c61635f 	stclvs	3, cr6, [r1], #-380	; 0xfffffe84
 660:	6e755f6c 	cdpvs	15, 7, cr5, cr5, cr12, {3}
 664:	65707865 	ldrbvs	r7, [r0, #-2149]!	; 0x865
 668:	64657463 	strbtvs	r7, [r5], #-1123	; 0x463
 66c:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 670:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 674:	5352565f 	cmppl	r2, #99614720	; 0x5f00000
 678:	706f505f 	rsbvc	r5, pc, pc, asr r0	; <UNPREDICTABLE>
 67c:	675f5f00 	ldrbvs	r5, [pc, -r0, lsl #30]
 680:	555f756e 	ldrbpl	r7, [pc, #-1390]	; 11a <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0xaca>
 684:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 688:	61535f64 	cmpvs	r3, r4, ror #30
 68c:	565f6576 			; <UNDEFINED> instruction: 0x565f6576
 690:	445f5046 	ldrbmi	r5, [pc], #-70	; 698 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x54c>
 694:	675f5f00 	ldrbvs	r5, [pc, -r0, lsl #30]
 698:	555f756e 	ldrbpl	r7, [pc, #-1390]	; 132 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0xab2>
 69c:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 6a0:	61535f64 	cmpvs	r3, r4, ror #30
 6a4:	565f6576 			; <UNDEFINED> instruction: 0x565f6576
 6a8:	5f005046 	svcpl	0x00005046
 6ac:	756e675f 	strbvc	r6, [lr, #-1887]!	; 0x75f
 6b0:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 6b4:	5f646e69 	svcpl	0x00646e69
 6b8:	65766153 	ldrbvs	r6, [r6, #-339]!	; 0x153
 6bc:	5046565f 	subpl	r5, r6, pc, asr r6
 6c0:	315f445f 	cmpcc	pc, pc, asr r4	; <UNPREDICTABLE>
 6c4:	6f745f36 	svcvs	0x00745f36
 6c8:	0031335f 	eorseq	r3, r1, pc, asr r3
 6cc:	6e675f5f 	mcrvs	15, 3, r5, cr7, cr15, {2}
 6d0:	6e555f75 	mrcvs	15, 2, r5, cr5, cr5, {3}
 6d4:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 6d8:	7661535f 			; <UNDEFINED> instruction: 0x7661535f
 6dc:	4d575f65 	ldclmi	15, cr5, [r7, #-404]	; 0xfffffe6c
 6e0:	0044584d 	subeq	r5, r4, sp, asr #16
 6e4:	6e675f5f 	mcrvs	15, 3, r5, cr7, cr15, {2}
 6e8:	6e555f75 	mrcvs	15, 2, r5, cr5, cr5, {3}
 6ec:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 6f0:	7661535f 			; <UNDEFINED> instruction: 0x7661535f
 6f4:	4d575f65 	ldclmi	15, cr5, [r7, #-404]	; 0xfffffe6c
 6f8:	0043584d 	subeq	r5, r3, sp, asr #16
 6fc:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 700:	5f646e69 	svcpl	0x00646e69
 704:	43746547 	cmnmi	r4, #297795584	; 0x11c00000
 708:	5f004146 	svcpl	0x00004146
 70c:	756e675f 	strbvc	r6, [lr, #-1887]!	; 0x75f
 710:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 714:	5f646e69 	svcpl	0x00646e69
 718:	73696152 	cmnvc	r9, #-2147483628	; 0x80000014
 71c:	63784565 	cmnvs	r8, #423624704	; 0x19400000
 720:	69747065 	ldmdbvs	r4!, {r0, r2, r5, r6, ip, sp, lr}^
 724:	5f006e6f 	svcpl	0x00006e6f
 728:	756e675f 	strbvc	r6, [lr, #-1887]!	; 0x75f
 72c:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 730:	5f646e69 	svcpl	0x00646e69
 734:	63726f46 	cmnvs	r2, #280	; 0x118
 738:	6e556465 	cdpvs	4, 5, cr6, cr5, cr5, {3}
 73c:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 740:	675f5f00 	ldrbvs	r5, [pc, -r0, lsl #30]
 744:	555f756e 	ldrbpl	r7, [pc, #-1390]	; 1de <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0xa06>
 748:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 74c:	65525f64 	ldrbvs	r5, [r2, #-3940]	; 0xf64
 750:	656d7573 	strbvs	r7, [sp, #-1395]!	; 0x573
 754:	675f5f00 	ldrbvs	r5, [pc, -r0, lsl #30]
 758:	555f756e 	ldrbpl	r7, [pc, #-1390]	; 1f2 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x9f2>
 75c:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 760:	65525f64 	ldrbvs	r5, [r2, #-3940]	; 0xf64
 764:	656d7573 	strbvs	r7, [sp, #-1395]!	; 0x573
 768:	5f726f5f 	svcpl	0x00726f5f
 76c:	68746552 	ldmdavs	r4!, {r1, r4, r6, r8, sl, sp, lr}^
 770:	00776f72 	rsbseq	r6, r7, r2, ror pc
 774:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 778:	5f646e69 	svcpl	0x00646e69
 77c:	706d6f43 	rsbvc	r6, sp, r3, asr #30
 780:	6574656c 	ldrbvs	r6, [r4, #-1388]!	; 0x56c
 784:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 788:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 78c:	6c65445f 	cfstrdvs	mvd4, [r5], #-380	; 0xfffffe84
 790:	45657465 	strbmi	r7, [r5, #-1125]!	; 0x465
 794:	70656378 	rsbvc	r6, r5, r8, ror r3
 798:	6e6f6974 	mcrvs	9, 3, r6, cr15, cr4, {3}
 79c:	675f5f00 	ldrbvs	r5, [pc, -r0, lsl #30]
 7a0:	555f756e 	ldrbpl	r7, [pc, #-1390]	; 23a <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x9aa>
 7a4:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 7a8:	61425f64 	cmpvs	r2, r4, ror #30
 7ac:	72746b63 	rsbsvc	r6, r4, #101376	; 0x18c00
 7b0:	00656361 	rsbeq	r6, r5, r1, ror #6
 7b4:	65725f5f 	ldrbvs	r5, [r2, #-3935]!	; 0xf5f
 7b8:	726f7473 	rsbvc	r7, pc, #1929379840	; 0x73000000
 7bc:	6f635f65 	svcvs	0x00635f65
 7c0:	725f6572 	subsvc	r6, pc, #478150656	; 0x1c800000
 7c4:	00736765 	rsbseq	r6, r3, r5, ror #14
 7c8:	555f5f5f 	ldrbpl	r5, [pc, #-3935]	; fffff871 <__bss_start+0xffffb86d>
 7cc:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 7d0:	61525f64 	cmpvs	r2, r4, ror #30
 7d4:	45657369 	strbmi	r7, [r5, #-873]!	; 0x369
 7d8:	70656378 	rsbvc	r6, r5, r8, ror r3
 7dc:	6e6f6974 	mcrvs	9, 3, r6, cr15, cr4, {3}
 7e0:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 7e4:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 7e8:	6961525f 	stmdbvs	r1!, {r0, r1, r2, r3, r4, r6, r9, ip, lr}^
 7ec:	78456573 	stmdavc	r5, {r0, r1, r4, r5, r6, r8, sl, sp, lr}^
 7f0:	74706563 	ldrbtvc	r6, [r0], #-1379	; 0x563
 7f4:	006e6f69 	rsbeq	r6, lr, r9, ror #30
 7f8:	555f5f5f 	ldrbpl	r5, [pc, #-3935]	; fffff8a1 <__bss_start+0xffffb89d>
 7fc:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 800:	65525f64 	ldrbvs	r5, [r2, #-3940]	; 0xf64
 804:	656d7573 	strbvs	r7, [sp, #-1395]!	; 0x573
 808:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 80c:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 810:	7365525f 	cmnvc	r5, #-268435451	; 0xf0000005
 814:	00656d75 	rsbeq	r6, r5, r5, ror sp
 818:	555f5f5f 	ldrbpl	r5, [pc, #-3935]	; fffff8c1 <__bss_start+0xffffb8bd>
 81c:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 820:	65525f64 	ldrbvs	r5, [r2, #-3940]	; 0xf64
 824:	656d7573 	strbvs	r7, [sp, #-1395]!	; 0x573
 828:	5f726f5f 	svcpl	0x00726f5f
 82c:	68746552 	ldmdavs	r4!, {r1, r4, r6, r8, sl, sp, lr}^
 830:	00776f72 	rsbseq	r6, r7, r2, ror pc
 834:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 838:	5f646e69 	svcpl	0x00646e69
 83c:	75736552 	ldrbvc	r6, [r3, #-1362]!	; 0x552
 840:	6f5f656d 	svcvs	0x005f656d
 844:	65525f72 	ldrbvs	r5, [r2, #-3954]	; 0xf72
 848:	6f726874 	svcvs	0x00726874
 84c:	5f5f0077 	svcpl	0x005f0077
 850:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 854:	5f646e69 	svcpl	0x00646e69
 858:	63726f46 	cmnvs	r2, #280	; 0x118
 85c:	6e556465 	cdpvs	4, 5, cr6, cr5, cr5, {3}
 860:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 864:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 868:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 86c:	726f465f 	rsbvc	r4, pc, #99614720	; 0x5f00000
 870:	55646563 	strbpl	r6, [r4, #-1379]!	; 0x563
 874:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 878:	5f5f0064 	svcpl	0x005f0064
 87c:	776e555f 			; <UNDEFINED> instruction: 0x776e555f
 880:	5f646e69 	svcpl	0x00646e69
 884:	6b636142 	blvs	18d8d94 <__bss_start+0x18d4d90>
 888:	63617274 	cmnvs	r1, #116, 4	; 0x40000007
 88c:	555f0065 	ldrbpl	r0, [pc, #-101]	; 82f <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x3b5>
 890:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 894:	61425f64 	cmpvs	r2, r4, ror #30
 898:	72746b63 	rsbsvc	r6, r4, #101376	; 0x18c00
 89c:	00656361 	rsbeq	r6, r5, r1, ror #6
 8a0:	6e675f5f 	mcrvs	15, 3, r5, cr7, cr15, {2}
 8a4:	6e755f75 	mrcvs	15, 3, r5, cr5, cr5, {3}
 8a8:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 8ac:	6172665f 	cmnvs	r2, pc, asr r6
 8b0:	5f00656d 	svcpl	0x0000656d
 8b4:	69776e55 	ldmdbvs	r7!, {r0, r2, r4, r6, r9, sl, fp, sp, lr}^
 8b8:	475f646e 	ldrbmi	r6, [pc, -lr, ror #8]
 8bc:	65527465 	ldrbvs	r7, [r2, #-1125]	; 0x465
 8c0:	6e6f6967 	cdpvs	9, 6, cr6, cr15, cr7, {3}
 8c4:	72617453 	rsbvc	r7, r1, #1392508928	; 0x53000000
 8c8:	555f0074 	ldrbpl	r0, [pc, #-116]	; 85c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x388>
 8cc:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 8d0:	65475f64 	strbvs	r5, [r7, #-3940]	; 0xf64
 8d4:	6e614c74 	mcrvs	12, 3, r4, cr1, cr4, {3}
 8d8:	67617567 	strbvs	r7, [r1, -r7, ror #10]!
 8dc:	65705365 	ldrbvs	r5, [r0, #-869]!	; 0x365
 8e0:	69666963 	stmdbvs	r6!, {r0, r1, r5, r6, r8, fp, sp, lr}^
 8e4:	74614463 	strbtvc	r4, [r1], #-1123	; 0x463
 8e8:	555f0061 	ldrbpl	r0, [pc, #-97]	; 88f <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x355>
 8ec:	6e69776e 	cdpvs	7, 6, cr7, cr9, cr14, {3}
 8f0:	65475f64 	strbvs	r5, [r7, #-3940]	; 0xf64
 8f4:	74614474 	strbtvc	r4, [r1], #-1140	; 0x474
 8f8:	6c655261 	sfmvs	f5, 2, [r5], #-388	; 0xfffffe7c
 8fc:	65736142 	ldrbvs	r6, [r3, #-322]!	; 0x142
 900:	6e555f00 	cdpvs	15, 5, cr5, cr5, cr0, {0}
 904:	646e6977 	strbtvs	r6, [lr], #-2423	; 0x977
 908:	7465475f 	strbtvc	r4, [r5], #-1887	; 0x75f
 90c:	74786554 	ldrbtvc	r6, [r8], #-1364	; 0x554
 910:	426c6552 	rsbmi	r6, ip, #343932928	; 0x14800000
 914:	00657361 	rsbeq	r7, r5, r1, ror #6
 918:	6164655f 	cmnvs	r4, pc, asr r5
 91c:	5f006174 	svcpl	0x00006174
 920:	7373625f 	cmnvc	r3, #-268435451	; 0xf0000005
 924:	6174735f 	cmnvs	r4, pc, asr r3
 928:	5f007472 	svcpl	0x00007472
 92c:	00646e65 	rsbeq	r6, r4, r5, ror #28
 930:	7362696c 	cmnvc	r2, #108, 18	; 0x1b0000
 934:	2b636474 	blcs	18d9b0c <__bss_start+0x18d5b08>
 938:	6f732e2b 	svcvs	0x00732e2b
 93c:	62696c00 	rsbvs	r6, r9, #0, 24
 940:	6f732e6d 	svcvs	0x00732e6d
 944:	62696c00 	rsbvs	r6, r9, #0, 24
 948:	6f732e63 	svcvs	0x00732e63
 94c:	62696c00 	rsbvs	r6, r9, #0, 24
 950:	732e6c64 	teqvc	lr, #100, 24	; 0x6400
 954:	696c006f 	stmdbvs	ip!, {r0, r1, r2, r3, r5, r6}^
 958:	6c654862 	stclvs	8, cr4, [r5], #-392	; 0xfffffe78
 95c:	6f576f6c 	svcvs	0x00576f6c
 960:	2e646c72 	mcrcs	12, 3, r6, cr4, cr2, {3}
 964:	Address 0x00000964 is out of bounds.


Disassembly of section .hash:

00000968 <.hash>:
 968:	00000025 	andeq	r0, r0, r5, lsr #32
 96c:	00000037 	andeq	r0, r0, r7, lsr r0
 970:	00000014 	andeq	r0, r0, r4, lsl r0
 974:	00000027 	andeq	r0, r0, r7, lsr #32
 978:	0000000d 	andeq	r0, r0, sp
 97c:	0000002b 	andeq	r0, r0, fp, lsr #32
 980:	0000002d 	andeq	r0, r0, sp, lsr #32
 984:	00000006 	andeq	r0, r0, r6
 988:	00000032 	andeq	r0, r0, r2, lsr r0
 98c:	00000000 	andeq	r0, r0, r0
 990:	0000002c 	andeq	r0, r0, ip, lsr #32
 994:	00000008 	andeq	r0, r0, r8
 998:	0000002a 	andeq	r0, r0, sl, lsr #32
 99c:	00000033 	andeq	r0, r0, r3, lsr r0
 9a0:	00000031 	andeq	r0, r0, r1, lsr r0
 9a4:	00000030 	andeq	r0, r0, r0, lsr r0
 9a8:	00000024 	andeq	r0, r0, r4, lsr #32
 9ac:	00000000 	andeq	r0, r0, r0
 9b0:	0000001b 	andeq	r0, r0, fp, lsl r0
 9b4:	00000023 	andeq	r0, r0, r3, lsr #32
 9b8:	00000034 	andeq	r0, r0, r4, lsr r0
 9bc:	00000012 	andeq	r0, r0, r2, lsl r0
 9c0:	00000016 	andeq	r0, r0, r6, lsl r0
 9c4:	00000026 	andeq	r0, r0, r6, lsr #32
	...
 9d0:	0000001c 	andeq	r0, r0, ip, lsl r0
 9d4:	0000001f 	andeq	r0, r0, pc, lsl r0
	...
 9e4:	0000002f 	andeq	r0, r0, pc, lsr #32
 9e8:	00000019 	andeq	r0, r0, r9, lsl r0
 9ec:	00000036 	andeq	r0, r0, r6, lsr r0
 9f0:	00000022 	andeq	r0, r0, r2, lsr #32
 9f4:	0000000f 	andeq	r0, r0, pc
 9f8:	00000015 	andeq	r0, r0, r5, lsl r0
 9fc:	00000035 	andeq	r0, r0, r5, lsr r0
	...
 a18:	00000004 	andeq	r0, r0, r4
	...
 a50:	0000000c 	andeq	r0, r0, ip
 a54:	00000000 	andeq	r0, r0, r0
 a58:	0000000a 	andeq	r0, r0, sl
 a5c:	00000000 	andeq	r0, r0, r0
 a60:	00000003 	andeq	r0, r0, r3
 a64:	00000000 	andeq	r0, r0, r0
 a68:	00000001 	andeq	r0, r0, r1
	...
 a78:	0000000e 	andeq	r0, r0, lr
 a7c:	00000017 	andeq	r0, r0, r7, lsl r0
 a80:	00000000 	andeq	r0, r0, r0
 a84:	00000011 	andeq	r0, r0, r1, lsl r0
 a88:	00000000 	andeq	r0, r0, r0
 a8c:	0000000b 	andeq	r0, r0, fp
 a90:	0000001a 	andeq	r0, r0, sl, lsl r0
 a94:	00000021 	andeq	r0, r0, r1, lsr #32
 a98:	00000005 	andeq	r0, r0, r5
 a9c:	00000009 	andeq	r0, r0, r9
 aa0:	0000001e 	andeq	r0, r0, lr, lsl r0
 aa4:	0000001d 	andeq	r0, r0, sp, lsl r0
 aa8:	00000018 	andeq	r0, r0, r8, lsl r0
 aac:	00000000 	andeq	r0, r0, r0
 ab0:	00000029 	andeq	r0, r0, r9, lsr #32
 ab4:	00000028 	andeq	r0, r0, r8, lsr #32
 ab8:	00000025 	andeq	r0, r0, r5, lsr #32
 abc:	00000007 	andeq	r0, r0, r7
	...
 ac8:	00000002 	andeq	r0, r0, r2
 acc:	0000002e 	andeq	r0, r0, lr, lsr #32
 ad0:	00000010 	andeq	r0, r0, r0, lsl r0
 ad4:	00000020 	andeq	r0, r0, r0, lsr #32
 ad8:	00000000 	andeq	r0, r0, r0
 adc:	00000013 	andeq	r0, r0, r3, lsl r0

Disassembly of section .rel.dyn:

00000ae0 <.rel.dyn>:
 ae0:	00003eb8 			; <UNDEFINED> instruction: 0x00003eb8
 ae4:	00000017 	andeq	r0, r0, r7, lsl r0
 ae8:	00003fc0 	andeq	r3, r0, r0, asr #31
 aec:	00000017 	andeq	r0, r0, r7, lsl r0
 af0:	00003fc4 	andeq	r3, r0, r4, asr #31
 af4:	00000017 	andeq	r0, r0, r7, lsl r0
 af8:	00003fc8 	andeq	r3, r0, r8, asr #31
 afc:	00000017 	andeq	r0, r0, r7, lsl r0
 b00:	00003fcc 	andeq	r3, r0, ip, asr #31
 b04:	00000017 	andeq	r0, r0, r7, lsl r0
 b08:	00003fd0 	ldrdeq	r3, [r0], -r0
 b0c:	00000017 	andeq	r0, r0, r7, lsl r0
 b10:	00003fbc 			; <UNDEFINED> instruction: 0x00003fbc
 b14:	00000515 	andeq	r0, r0, r5, lsl r5
 b18:	00003fd4 	ldrdeq	r3, [r0], -r4
 b1c:	00001515 	andeq	r1, r0, r5, lsl r5

Disassembly of section .rel.plt:

00000b20 <.rel.plt>:
 b20:	00003fe4 	andeq	r3, r0, r4, ror #31
 b24:	00000216 	andeq	r0, r0, r6, lsl r2
 b28:	00003fe8 	andeq	r3, r0, r8, ror #31
 b2c:	00000116 	andeq	r0, r0, r6, lsl r1
 b30:	00003fec 	andeq	r3, r0, ip, ror #31
 b34:	00000516 	andeq	r0, r0, r6, lsl r5
 b38:	00003ff0 	strdeq	r3, [r0], -r0
 b3c:	00000d16 	andeq	r0, r0, r6, lsl sp
 b40:	00003ff4 	strdeq	r3, [r0], -r4
 b44:	00000f16 	andeq	r0, r0, r6, lsl pc
 b48:	00003ff8 	strdeq	r3, [r0], -r8
 b4c:	00001216 	andeq	r1, r0, r6, lsl r2
 b50:	00003ffc 	strdeq	r3, [r0], -ip
 b54:	00001316 	andeq	r1, r0, r6, lsl r3

Disassembly of section .plt:

00000b58 <.plt>:
 b58:	e52de004 	push	{lr}		; (str lr, [sp, #-4]!)
 b5c:	e59fe004 	ldr	lr, [pc, #4]	; b68 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x7c>
 b60:	e08fe00e 	add	lr, pc, lr
 b64:	e5bef008 	ldr	pc, [lr, #8]!
 b68:	00003470 	andeq	r3, r0, r0, ror r4
 b6c:	e28fc600 	add	ip, pc, #0, 12
 b70:	e28cca03 	add	ip, ip, #12288	; 0x3000
 b74:	e5bcf470 	ldr	pc, [ip, #1136]!	; 0x470
 b78:	e28fc600 	add	ip, pc, #0, 12
 b7c:	e28cca03 	add	ip, ip, #12288	; 0x3000
 b80:	e5bcf468 	ldr	pc, [ip, #1128]!	; 0x468
 b84:	e28fc600 	add	ip, pc, #0, 12
 b88:	e28cca03 	add	ip, ip, #12288	; 0x3000
 b8c:	e5bcf460 	ldr	pc, [ip, #1120]!	; 0x460
 b90:	e28fc600 	add	ip, pc, #0, 12
 b94:	e28cca03 	add	ip, ip, #12288	; 0x3000
 b98:	e5bcf458 	ldr	pc, [ip, #1112]!	; 0x458
 b9c:	e28fc600 	add	ip, pc, #0, 12
 ba0:	e28cca03 	add	ip, ip, #12288	; 0x3000
 ba4:	e5bcf450 	ldr	pc, [ip, #1104]!	; 0x450
 ba8:	e28fc600 	add	ip, pc, #0, 12
 bac:	e28cca03 	add	ip, ip, #12288	; 0x3000
 bb0:	e5bcf448 	ldr	pc, [ip, #1096]!	; 0x448
 bb4:	e28fc600 	add	ip, pc, #0, 12
 bb8:	e28cca03 	add	ip, ip, #12288	; 0x3000
 bbc:	e5bcf440 	ldr	pc, [ip, #1088]!	; 0x440

Disassembly of section .text:

00000bc0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x24>:
     bc0:	e59f2008 	ldr	r2, [pc, #8]	; bd0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x14>
     bc4:	e3a01000 	mov	r1, #0
     bc8:	e08f2002 	add	r2, pc, r2
     bcc:	eaffffe6 	b	b6c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x78>
     bd0:	00003430 	andeq	r3, r0, r0, lsr r4
     bd4:	e59f0004 	ldr	r0, [pc, #4]	; be0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x4>
     bd8:	e08f0000 	add	r0, pc, r0
     bdc:	eaffffe5 	b	b78 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x6c>
     be0:	00003420 	andeq	r3, r0, r0, lsr #8

00000be4 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject>:
     be4:	2000      	movs	r0, #0
     be6:	4770      	bx	lr
     be8:	3000      	adds	r0, #0
     bea:	e590      	b.n	70e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x4d6>
     bec:	0101      	lsls	r1, r0, #4
     bee:	e313      	b.n	1218 <_Unwind_VRS_Set+0x200>
     bf0:	3102      	adds	r1, #2
     bf2:	1383      	asrs	r3, r0, #14
     bf4:	3102      	adds	r1, #2
     bf6:	03c3      	lsls	r3, r0, #15
     bf8:	0003      	movs	r3, r0
     bfa:	e080      	b.n	cfe <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x11a>
     bfc:	ff1e e12f 	vrhadd.u16	d14, d14, d31
     c00:	4ff0      	ldr	r7, [pc, #960]	; (fc4 <_Unwind_VRS_Get+0x18>)
     c02:	e92d 51ac 	stmdb	sp!, {r2, r3, r5, r7, r8, ip, lr}
     c06:	e59f      	b.n	748 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x49c>
     c08:	31ac      	adds	r1, #172	; 0xac
     c0a:	e59f      	b.n	74c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x498>
     c0c:	5005      	str	r5, [r0, r0]
     c0e:	e08f      	b.n	d30 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x14c>
     c10:	3003      	adds	r0, #3
     c12:	e795      	b.n	b40 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0xa4>
     c14:	d014      	beq.n	c40 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x5c>
     c16:	e24d      	b.n	10b4 <_Unwind_VRS_Set+0x9c>
     c18:	0000      	movs	r0, r0
     c1a:	e353      	b.n	12c4 <_Unwind_VRS_Set+0x2ac>
     c1c:	4000      	ands	r0, r0
     c1e:	e1a0      	b.n	f62 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x37e>
     c20:	6002      	str	r2, [r0, #0]
     c22:	e241      	b.n	10a8 <_Unwind_VRS_Set+0x90>
     c24:	0005      	movs	r5, r0
     c26:	0a00      	lsrs	r0, r0, #8
     c28:	0006      	movs	r6, r0
     c2a:	e1a0      	b.n	f6e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x38a>
     c2c:	100c      	asrs	r4, r1, #32
     c2e:	e28d      	b.n	114c <_Unwind_VRS_Set+0x134>
     c30:	ffd3 ebff 			; <UNDEFINED> instruction: 0xffd3ebff
     c34:	9000      	str	r0, [sp, #0]
     c36:	e250      	b.n	10da <_Unwind_VRS_Set+0xc2>
     c38:	0007      	movs	r7, r0
     c3a:	1a00      	subs	r0, r0, r0
     c3c:	0056      	lsls	r6, r2, #1
     c3e:	ea00 3178 	and.w	r1, r0, r8, ror #13
     c42:	e59f      	b.n	784 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x460>
     c44:	2178      	movs	r1, #120	; 0x78
     c46:	e59f      	b.n	788 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x45c>
     c48:	3003      	adds	r0, #3
     c4a:	e795      	b.n	b78 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x6c>
     c4c:	9002      	str	r0, [sp, #8]
     c4e:	e795      	b.n	b7c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x68>
     c50:	3003      	adds	r0, #3
     c52:	e069      	b.n	d28 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x144>
     c54:	31c3      	adds	r1, #195	; 0xc3
     c56:	e1a0      	b.n	f9a <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x3b6>
     c58:	300c      	adds	r0, #12
     c5a:	e58d      	b.n	778 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x46c>
     c5c:	300c      	adds	r0, #12
     c5e:	e59d      	b.n	79c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x448>
     c60:	0000      	movs	r0, r0
     c62:	e353      	b.n	130c <_Unwind_VRS_Set+0x2f4>
     c64:	0021      	movs	r1, r4
     c66:	0a00      	lsrs	r0, r0, #8
     c68:	3001      	adds	r0, #1
     c6a:	e243      	b.n	10f4 <_Unwind_VRS_Set+0xdc>
     c6c:	b003      	add	sp, #12
     c6e:	e1a0      	b.n	fb2 <_Unwind_VRS_Get+0x6>
     c70:	a000      	add	r0, pc, #0	; (adr r0, c74 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x90>)
     c72:	e3a0      	b.n	13b6 <_Unwind_VRS_Set+0x39e>
     c74:	3004      	adds	r0, #4
     c76:	e58d      	b.n	794 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x450>
     c78:	700b      	strb	r3, [r1, #0]
     c7a:	e08a      	b.n	d92 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1ae>
     c7c:	7fa7      	ldrb	r7, [r4, #30]
     c7e:	e087      	b.n	d90 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1ac>
     c80:	70c7      	strb	r7, [r0, #3]
     c82:	e1a0      	b.n	fc6 <_Unwind_VRS_Get+0x1a>
     c84:	8187      	strh	r7, [r0, #12]
     c86:	e089      	b.n	d9c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1b8>
     c88:	0008      	movs	r0, r1
     c8a:	e1a0      	b.n	fce <_Unwind_VRS_Get+0x22>
     c8c:	ffd5 ebff 			; <UNDEFINED> instruction: 0xffd5ebff
     c90:	2004      	movs	r0, #4
     c92:	e59d      	b.n	7d0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x414>
     c94:	0002      	movs	r2, r0
     c96:	e157      	b.n	f48 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x364>
     c98:	3000      	adds	r0, #0
     c9a:	e1a0      	b.n	fde <_Unwind_VRS_Get+0x32>
     c9c:	0000      	movs	r0, r0
     c9e:	03e0      	lsls	r0, r4, #15
     ca0:	0005      	movs	r5, r0
     ca2:	0a00      	lsrs	r0, r0, #8
     ca4:	0001      	movs	r1, r0
     ca6:	e287      	b.n	11b8 <_Unwind_VRS_Set+0x1a0>
     ca8:	0180      	lsls	r0, r0, #6
     caa:	e089      	b.n	dc0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1dc>
     cac:	3000      	adds	r0, #0
     cae:	e58d      	b.n	7cc <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x418>
     cb0:	ffcc ebff 			; <UNDEFINED> instruction: 0xffccebff
     cb4:	3000      	adds	r0, #0
     cb6:	e59d      	b.n	7f4 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x3f0>
     cb8:	0001      	movs	r1, r0
     cba:	e240      	b.n	113e <_Unwind_VRS_Set+0x126>
     cbc:	0003      	movs	r3, r0
     cbe:	e156      	b.n	f6e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x38a>
     cc0:	0003      	movs	r3, r0
     cc2:	2a00      	cmp	r2, #0
     cc4:	000a      	movs	r2, r1
     cc6:	e157      	b.n	f78 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x394>
     cc8:	0008      	movs	r0, r1
     cca:	0a00      	lsrs	r0, r0, #8
     ccc:	b001      	add	sp, #4
     cce:	e247      	b.n	1160 <_Unwind_VRS_Set+0x148>
     cd0:	ffe8 eaff 			; <UNDEFINED> instruction: 0xffe8eaff
     cd4:	0000      	movs	r0, r0
     cd6:	e156      	b.n	f86 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x3a2>
     cd8:	0002      	movs	r2, r0
     cda:	8a00      	ldrh	r0, [r0, #16]
     cdc:	0000      	movs	r0, r0
     cde:	e358      	b.n	1392 <_Unwind_VRS_Set+0x37a>
     ce0:	0006      	movs	r6, r0
     ce2:	1a00      	subs	r0, r0, r0
     ce4:	0001      	movs	r1, r0
     ce6:	ea00 a001 			; <UNDEFINED> instruction: 0xea00a001
     cea:	e287      	b.n	11fc <_Unwind_VRS_Set+0x1e4>
     cec:	ffe1 eaff 			; <UNDEFINED> instruction: 0xffe1eaff
     cf0:	3000      	adds	r0, #0
     cf2:	e3a0      	b.n	1436 <_Unwind_VRS_Pop+0x2>
     cf4:	3010      	adds	r0, #16
     cf6:	e584      	b.n	802 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x3e2>
     cf8:	0009      	movs	r1, r1
     cfa:	e3a0      	b.n	143e <_Unwind_VRS_Pop+0xa>
     cfc:	002b      	movs	r3, r5
     cfe:	ea00 0008 	and.w	r0, r0, r8
     d02:	e1a0      	b.n	1046 <_Unwind_VRS_Set+0x2e>
     d04:	ffb7 ebff 			; <UNDEFINED> instruction: 0xffb7ebff
     d08:	3004      	adds	r0, #4
     d0a:	e598      	b.n	83e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x3a6>
     d0c:	0001      	movs	r1, r0
     d0e:	e353      	b.n	13b8 <_Unwind_VRS_Set+0x3a0>
     d10:	3000      	adds	r0, #0
     d12:	03a0      	lsls	r0, r4, #14
     d14:	3010      	adds	r0, #16
     d16:	0584      	lsls	r4, r0, #22
     d18:	0048      	lsls	r0, r1, #1
     d1a:	e584      	b.n	826 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x3be>
     d1c:	0005      	movs	r5, r0
     d1e:	03a0      	lsls	r0, r4, #14
     d20:	0022      	movs	r2, r4
     d22:	0a00      	lsrs	r0, r0, #8
     d24:	0000      	movs	r0, r0
     d26:	e353      	b.n	13d0 <_Unwind_VRS_Set+0x3b8>
     d28:	0004      	movs	r4, r0
     d2a:	e288      	b.n	123e <_Unwind_VRS_Set+0x226>
     d2c:	004c      	lsls	r4, r1, #1
     d2e:	b584      	push	{r2, r7, lr}
     d30:	3001      	adds	r0, #1
     d32:	b3a0      	cbz	r0, d9e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1ba>
     d34:	0002      	movs	r2, r0
     d36:	ba00      	rev	r0, r0
     d38:	ffaa ebff 			; <UNDEFINED> instruction: 0xffaaebff
     d3c:	3000      	adds	r0, #0
     d3e:	e3a0      	b.n	1482 <_Unwind_VRS_Pop+0x4e>
     d40:	004c      	lsls	r4, r1, #1
     d42:	e584      	b.n	84e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x396>
     d44:	004c      	lsls	r4, r1, #1
     d46:	e594      	b.n	872 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x372>
     d48:	3050      	adds	r0, #80	; 0x50
     d4a:	e584      	b.n	856 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x38e>
     d4c:	3000      	adds	r0, #0
     d4e:	e590      	b.n	872 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x372>
     d50:	0000      	movs	r0, r0
     d52:	e353      	b.n	13fc <_Unwind_VRS_Set+0x3e4>
     d54:	0012      	movs	r2, r2
     d56:	aa00      	add	r2, sp, #0
     d58:	3c23      	subs	r4, #35	; 0x23
     d5a:	e1a0      	b.n	109e <_Unwind_VRS_Set+0x86>
     d5c:	300f      	adds	r0, #15
     d5e:	e213      	b.n	1188 <_Unwind_VRS_Set+0x170>
     d60:	2060      	movs	r0, #96	; 0x60
     d62:	059f      	lsls	r7, r3, #22
     d64:	0003      	movs	r3, r0
     d66:	01a0      	lsls	r0, r4, #6
     d68:	2002      	movs	r0, #2
     d6a:	0795      	lsls	r5, r2, #30
     d6c:	2010      	movs	r0, #16
     d6e:	0584      	lsls	r4, r0, #22
     d70:	000e      	movs	r6, r1
     d72:	0a00      	lsrs	r0, r0, #8
     d74:	0001      	movs	r1, r0
     d76:	e353      	b.n	1420 <__aeabi_unwind_cpp_pr2+0x4>
     d78:	0000      	movs	r0, r0
     d7a:	e3a0      	b.n	14be <_Unwind_VRS_Pop+0x8a>
     d7c:	3048      	adds	r0, #72	; 0x48
     d7e:	059f      	lsls	r7, r3, #22
     d80:	0002      	movs	r2, r0
     d82:	0a00      	lsrs	r0, r0, #8
     d84:	0002      	movs	r2, r0
     d86:	e353      	b.n	1430 <__aeabi_unwind_cpp_pr0+0x4>
     d88:	0003      	movs	r3, r0
     d8a:	1a00      	subs	r0, r0, r0
     d8c:	303c      	adds	r0, #60	; 0x3c
     d8e:	e59f      	b.n	8d0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x314>
     d90:	3003      	adds	r0, #3
     d92:	e795      	b.n	cc0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0xdc>
     d94:	3010      	adds	r0, #16
     d96:	e584      	b.n	8a2 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x342>
     d98:	0004      	movs	r4, r0
     d9a:	ea00 0010 	and.w	r0, r0, r0, lsr #32
     d9e:	e584      	b.n	8aa <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x33a>
     da0:	ffd4 eaff 			; <UNDEFINED> instruction: 0xffd4eaff
     da4:	ff8f ebff 			; <UNDEFINED> instruction: 0xff8febff
     da8:	0010      	movs	r0, r2
     daa:	e584      	b.n	8b6 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x32e>
     dac:	0000      	movs	r0, r0
     dae:	e3a0      	b.n	14f2 <_Unwind_VRS_Pop+0xbe>
     db0:	d014      	beq.n	ddc <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1f8>
     db2:	e28d      	b.n	12d0 <_Unwind_VRS_Set+0x2b8>
     db4:	8ff0      	ldrh	r0, [r6, #62]	; 0x3e
     db6:	e8bd 33c4 	ldmia.w	sp!, {r2, r6, r7, r8, r9, ip, sp}
     dba:	0000      	movs	r0, r0
     dbc:	ffe4 ffff 			; <UNDEFINED> instruction: 0xffe4ffff
     dc0:	ffe8 ffff 			; <UNDEFINED> instruction: 0xffe8ffff
     dc4:	ffec ffff 			; <UNDEFINED> instruction: 0xffecffff
     dc8:	fff0 ffff 			; <UNDEFINED> instruction: 0xfff0ffff
     dcc:	fff4 ffff 			; <UNDEFINED> instruction: 0xfff4ffff
     dd0:	fff8 ffff 			; <UNDEFINED> instruction: 0xfff8ffff
     dd4:	3000      	adds	r0, #0
     dd6:	e590      	b.n	8fa <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x2ea>
     dd8:	4010      	ands	r0, r2
     dda:	e92d 0001 	stmdb	sp!, {r0}
     dde:	e313      	b.n	1408 <_Unwind_VRS_Set+0x3f0>
     de0:	4000      	ands	r0, r0
     de2:	e1a0      	b.n	1126 <_Unwind_VRS_Set+0x10e>
     de4:	0005      	movs	r5, r0
     de6:	1a00      	subs	r0, r0, r0
     de8:	0002      	movs	r2, r0
     dea:	e313      	b.n	1414 <_Unwind_VRS_Set+0x3fc>
     dec:	0048      	lsls	r0, r1, #1
     dee:	e280      	b.n	12f2 <_Unwind_VRS_Set+0x2da>
     df0:	0001      	movs	r1, r0
     df2:	0a00      	lsrs	r0, r0, #8
     df4:	02fb      	lsls	r3, r7, #11
     df6:	eb00 0000 	add.w	r0, r0, r0
     dfa:	ea00 02f5 	and.w	r2, r0, r5, ror #3
     dfe:	eb00 3000 	add.w	r0, r0, r0, lsl #12
     e02:	e594      	b.n	92e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x2b6>
     e04:	0004      	movs	r4, r0
     e06:	e313      	b.n	1430 <__aeabi_unwind_cpp_pr0+0x4>
     e08:	0001      	movs	r1, r0
     e0a:	1a00      	subs	r0, r0, r0
     e0c:	00d0      	lsls	r0, r2, #3
     e0e:	e284      	b.n	131a <_Unwind_VRS_Set+0x302>
     e10:	02f8      	lsls	r0, r7, #11
     e12:	eb00 3000 	add.w	r0, r0, r0, lsl #12
     e16:	e594      	b.n	942 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x2a2>
     e18:	0008      	movs	r0, r1
     e1a:	e313      	b.n	1444 <_Unwind_VRS_Pop+0x10>
     e1c:	0001      	movs	r1, r0
     e1e:	1a00      	subs	r0, r0, r0
     e20:	0e1b      	lsrs	r3, r3, #24
     e22:	e284      	b.n	132e <_Unwind_VRS_Set+0x316>
     e24:	02f7      	lsls	r7, r6, #11
     e26:	eb00 3000 	add.w	r0, r0, r0, lsl #12
     e2a:	e594      	b.n	956 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x28e>
     e2c:	0010      	movs	r0, r2
     e2e:	e313      	b.n	1458 <_Unwind_VRS_Pop+0x24>
     e30:	8010      	strh	r0, [r2, #0]
     e32:	18bd      	adds	r5, r7, r2
     e34:	0e23      	lsrs	r3, r4, #24
     e36:	e284      	b.n	1342 <_Unwind_VRS_Set+0x32a>
     e38:	4010      	ands	r0, r2
     e3a:	e8bd 0313 	ldmia.w	sp!, {r0, r1, r4, r8, r9}
     e3e:	ea00 47f0 	and.w	r7, r0, r0, ror #19
     e42:	e92d e004 	stmdb	sp!, {r2, sp, lr, pc}
     e46:	e281      	b.n	134c <_Unwind_VRS_Set+0x334>
     e48:	800c      	strh	r4, [r1, #0]
     e4a:	e590      	b.n	96e <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x276>
     e4c:	9018      	str	r0, [sp, #96]	; 0x60
     e4e:	e590      	b.n	972 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x272>
     e50:	dd12      	ble.n	e78 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x294>
     e52:	e24d      	b.n	12f0 <_Unwind_VRS_Set+0x2d8>
     e54:	4000      	ands	r0, r0
     e56:	e1a0      	b.n	119a <_Unwind_VRS_Set+0x182>
     e58:	5002      	str	r2, [r0, r0]
     e5a:	e1a0      	b.n	119e <_Unwind_VRS_Set+0x186>
     e5c:	000f      	movs	r7, r1
     e5e:	e8be d008 	ldmia.w	lr!, {r3, ip, lr, pc}
     e62:	e24d      	b.n	1300 <_Unwind_VRS_Set+0x2e8>
     e64:	c00c      	stmia	r0!, {r2, r3}
     e66:	e28d      	b.n	1384 <_Unwind_VRS_Set+0x36c>
     e68:	000f      	movs	r7, r1
     e6a:	e8ac 000f 	stmia.w	ip!, {r0, r1, r2, r3}
     e6e:	e8be 000f 	ldmia.w	lr!, {r0, r1, r2, r3}
     e72:	e8ac 000f 	stmia.w	ip!, {r0, r1, r2, r3}
     e76:	e8be 000f 	ldmia.w	lr!, {r0, r1, r2, r3}
     e7a:	e8ac 000f 	stmia.w	ip!, {r0, r1, r2, r3}
     e7e:	e89e 7000 	ldmia.w	lr, {ip, sp, lr}
     e82:	e3a0      	b.n	15c6 <_Unwind_VRS_Pop+0x192>
     e84:	6008      	str	r0, [r1, #0]
     e86:	e28d      	b.n	13a4 <_Unwind_VRS_Set+0x38c>
     e88:	000f      	movs	r7, r1
     e8a:	e88c 7008 	stmia.w	ip, {r3, ip, sp, lr}
     e8e:	e58d      	b.n	9ac <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x238>
     e90:	0004      	movs	r4, r0
     e92:	e1a0      	b.n	11d6 <_Unwind_VRS_Set+0x1be>
     e94:	1048      	asrs	r0, r1, #1
     e96:	e59d      	b.n	9d4 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x210>
     e98:	ff58 ebff 			; <UNDEFINED> instruction: 0xff58ebff
     e9c:	0000      	movs	r0, r0
     e9e:	e355      	b.n	154c <_Unwind_VRS_Pop+0x118>
     ea0:	a00a      	add	r0, pc, #40	; (adr r0, ecc <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x2e8>)
     ea2:	13a0      	asrs	r0, r4, #14
     ea4:	a009      	add	r0, pc, #36	; (adr r0, ecc <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x2e8>)
     ea6:	03a0      	lsls	r0, r4, #14
     ea8:	5000      	str	r0, [r0, r0]
     eaa:	e250      	b.n	134e <_Unwind_VRS_Set+0x336>
     eac:	a010      	add	r0, pc, #64	; (adr r0, ef0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x30c>)
     eae:	138a      	asrs	r2, r1, #14
     eb0:	3040      	adds	r0, #64	; 0x40
     eb2:	159d      	asrs	r5, r3, #22
     eb4:	000c      	movs	r4, r1
     eb6:	1a00      	subs	r0, r0, r0
     eb8:	3048      	adds	r0, #72	; 0x48
     eba:	e59d      	b.n	9f8 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x1ec>
     ebc:	3014      	adds	r0, #20
     ebe:	e584      	b.n	9ca <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x21a>
     ec0:	1006      	asrs	r6, r0, #32
     ec2:	e1a0      	b.n	1206 <_Unwind_VRS_Set+0x1ee>
     ec4:	2d09      	cmp	r5, #9
     ec6:	e3a0      	b.n	160a <_Unwind_VRS_Pop+0x1d6>
     ec8:	0f92      	lsrs	r2, r2, #30
     eca:	e28d      	b.n	13e8 <_Unwind_VRS_Set+0x3d0>
     ecc:	ff2f ebff 			; <UNDEFINED> instruction: 0xff2febff
     ed0:	3010      	adds	r0, #16
     ed2:	e594      	b.n	9fe <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x1e6>
     ed4:	000a      	movs	r2, r1
     ed6:	e1a0      	b.n	121a <_Unwind_VRS_Set+0x202>
     ed8:	1004      	asrs	r4, r0, #32
     eda:	e1a0      	b.n	121e <_Unwind_VRS_Set+0x206>
     edc:	2f92      	cmp	r7, #146	; 0x92
     ede:	e28d      	b.n	13fc <_Unwind_VRS_Set+0x3e4>
     ee0:	ff33 e12f 	vrhadd.u<illegal width 64>	d14, d3, d31
     ee4:	3280      	adds	r2, #128	; 0x80
     ee6:	e59d      	b.n	a24 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x1c0>
     ee8:	7000      	strb	r0, [r0, #0]
     eea:	e1a0      	b.n	122e <_Unwind_VRS_Set+0x216>
     eec:	304c      	adds	r0, #76	; 0x4c
     eee:	e58d      	b.n	a0c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x1d8>
     ef0:	0240      	lsls	r0, r0, #9
     ef2:	e88d 0001 	stmia.w	sp, {r0}
     ef6:	e3a0      	b.n	163a <_Unwind_VRS_Pop+0x206>
     ef8:	100a      	asrs	r2, r1, #32
     efa:	e1a0      	b.n	123e <_Unwind_VRS_Set+0x226>
     efc:	2004      	movs	r0, #4
     efe:	e1a0      	b.n	1242 <_Unwind_VRS_Set+0x22a>
     f00:	3004      	adds	r0, #4
     f02:	e1a0      	b.n	1246 <_Unwind_VRS_Set+0x22e>
     f04:	ff38 e12f 	vrhadd.u<illegal width 64>	d14, d8, d31
     f08:	0000      	movs	r0, r0
     f0a:	e350      	b.n	15ae <_Unwind_VRS_Pop+0x17a>
     f0c:	000b      	movs	r3, r1
     f0e:	1a00      	subs	r0, r0, r0
     f10:	0000      	movs	r0, r0
     f12:	e355      	b.n	15c0 <_Unwind_VRS_Pop+0x18c>
     f14:	000a      	movs	r2, r1
     f16:	1a00      	subs	r0, r0, r0
     f18:	0006      	movs	r6, r0
     f1a:	e1a0      	b.n	125e <_Unwind_VRS_Set+0x246>
     f1c:	1f92      	subs	r2, r2, #6
     f1e:	e28d      	b.n	143c <_Unwind_VRS_Pop+0x8>
     f20:	2d09      	cmp	r5, #9
     f22:	e3a0      	b.n	1666 <_Unwind_VRS_Pop+0x232>
     f24:	ff19 ebff 			; <UNDEFINED> instruction: 0xff19ebff
     f28:	0008      	movs	r0, r1
     f2a:	e357      	b.n	15dc <_Unwind_VRS_Pop+0x1a8>
     f2c:	ffd7 0aff 			; <UNDEFINED> instruction: 0xffd70aff
     f30:	0007      	movs	r7, r0
     f32:	e357      	b.n	15e4 <_Unwind_VRS_Pop+0x1b0>
     f34:	0001      	movs	r1, r0
     f36:	1a00      	subs	r0, r0, r0
     f38:	0004      	movs	r4, r0
     f3a:	e286      	b.n	144a <_Unwind_VRS_Pop+0x16>
     f3c:	02a0      	lsls	r0, r4, #10
     f3e:	eb00 5009 	add.w	r0, r0, r9, lsl #20
     f42:	e3a0      	b.n	1686 <_Unwind_VRS_Pop+0x252>
     f44:	0005      	movs	r5, r0
     f46:	e1a0      	b.n	128a <_Unwind_VRS_Set+0x272>
     f48:	d088      	beq.n	e5c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x278>
     f4a:	e28d      	b.n	1468 <_Unwind_VRS_Pop+0x34>
     f4c:	db01      	blt.n	f52 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x36e>
     f4e:	e28d      	b.n	146c <_Unwind_VRS_Pop+0x38>
     f50:	87f0      	strh	r0, [r6, #62]	; 0x3e
     f52:	e8bd 4038 	ldmia.w	sp!, {r3, r4, r5, lr}
     f56:	e92d 5000 	stmdb	sp!, {ip, lr}
     f5a:	e1a0      	b.n	129e <_Unwind_VRS_Set+0x286>
     f5c:	4001      	ands	r1, r0
     f5e:	e1a0      	b.n	12a2 <_Unwind_VRS_Set+0x28a>
     f60:	0005      	movs	r5, r0
     f62:	e1a0      	b.n	12a6 <_Unwind_VRS_Set+0x28e>
     f64:	1040      	asrs	r0, r0, #1
     f66:	e594      	b.n	a92 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x152>
     f68:	ff24 ebff 			; <UNDEFINED> instruction: 0xff24ebff
     f6c:	0000      	movs	r0, r0
     f6e:	e350      	b.n	1612 <_Unwind_VRS_Pop+0x1de>
     f70:	000a      	movs	r2, r1
     f72:	1a00      	subs	r0, r0, r0
     f74:	3040      	adds	r0, #64	; 0x40
     f76:	e594      	b.n	aa2 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x142>
     f78:	3014      	adds	r0, #20
     f7a:	e585      	b.n	a88 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x15c>
     f7c:	0001      	movs	r1, r0
     f7e:	e3a0      	b.n	16c2 <_Unwind_VRS_Pop+0x28e>
     f80:	3010      	adds	r0, #16
     f82:	e595      	b.n	ab0 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x134>
     f84:	1005      	asrs	r5, r0, #32
     f86:	e1a0      	b.n	12ca <_Unwind_VRS_Set+0x2b2>
     f88:	2004      	movs	r0, #4
     f8a:	e1a0      	b.n	12ce <_Unwind_VRS_Set+0x2b6>
     f8c:	ff33 e12f 	vrhadd.u<illegal width 64>	d14, d3, d31
     f90:	0008      	movs	r0, r1
     f92:	e350      	b.n	1636 <_Unwind_VRS_Pop+0x202>
     f94:	fff1 0aff 			; <UNDEFINED> instruction: 0xfff10aff
     f98:	0007      	movs	r7, r0
     f9a:	e350      	b.n	163e <_Unwind_VRS_Pop+0x20a>
     f9c:	0000      	movs	r0, r0
     f9e:	0a00      	lsrs	r0, r0, #8
     fa0:	fefd ebff 	mrc2	11, 7, lr, cr13, cr15, {7}
     fa4:	0004      	movs	r4, r0
     fa6:	e284      	b.n	14b2 <_Unwind_VRS_Pop+0x7e>
     fa8:	0285      	lsls	r5, r0, #10
     faa:	eb00 0000 	add.w	r0, r0, r0

00000fac <_Unwind_VRS_Get>:
     fac:	e3510000 	cmp	r1, #0
     fb0:	0a000003 	beq	fc4 <_Unwind_VRS_Get+0x18>
     fb4:	e3510004 	cmp	r1, #4
     fb8:	83a00002 	movhi	r0, #2
     fbc:	93a00001 	movls	r0, #1
     fc0:	e12fff1e 	bx	lr
     fc4:	e352000f 	cmp	r2, #15
     fc8:	93530000 	cmpls	r3, #0
     fcc:	00800102 	addeq	r0, r0, r2, lsl #2
     fd0:	059d2000 	ldreq	r2, [sp]
     fd4:	05901004 	ldreq	r1, [r0, #4]
     fd8:	03a03000 	moveq	r3, #0
     fdc:	13a03001 	movne	r3, #1
     fe0:	05821000 	streq	r1, [r2]
     fe4:	01a00003 	moveq	r0, r3
     fe8:	13a00002 	movne	r0, #2
     fec:	e12fff1e 	bx	lr
     ff0:	e92d401f 	push	{r0, r1, r2, r3, r4, lr}
     ff4:	e1a02001 	mov	r2, r1
     ff8:	e28d300c 	add	r3, sp, #12
     ffc:	e3a01000 	mov	r1, #0
    1000:	e58d3000 	str	r3, [sp]
    1004:	e1a03001 	mov	r3, r1
    1008:	ebffffe7 	bl	fac <_Unwind_VRS_Get>
    100c:	e59d000c 	ldr	r0, [sp, #12]
    1010:	e28dd014 	add	sp, sp, #20
    1014:	e8bd8000 	ldmfd	sp!, {pc}

00001018 <_Unwind_VRS_Set>:
    1018:	e3510000 	cmp	r1, #0
    101c:	0a000003 	beq	1030 <_Unwind_VRS_Set+0x18>
    1020:	e3510004 	cmp	r1, #4
    1024:	83a00002 	movhi	r0, #2
    1028:	93a00001 	movls	r0, #1
    102c:	e12fff1e 	bx	lr
    1030:	e352000f 	cmp	r2, #15
    1034:	93530000 	cmpls	r3, #0
    1038:	059d1000 	ldreq	r1, [sp]
    103c:	00800102 	addeq	r0, r0, r2, lsl #2
    1040:	03a03000 	moveq	r3, #0
    1044:	13a03001 	movne	r3, #1
    1048:	05911000 	ldreq	r1, [r1]
    104c:	05801004 	streq	r1, [r0, #4]
    1050:	13a00002 	movne	r0, #2
    1054:	01a00003 	moveq	r0, r3
    1058:	e12fff1e 	bx	lr
    105c:	e92d401f 	push	{r0, r1, r2, r3, r4, lr}
    1060:	e1a03001 	mov	r3, r1
    1064:	e28d1010 	add	r1, sp, #16
    1068:	e5212004 	str	r2, [r1, #-4]!
    106c:	e58d1000 	str	r1, [sp]
    1070:	e3a01000 	mov	r1, #0
    1074:	e1a02003 	mov	r2, r3
    1078:	e1a03001 	mov	r3, r1
    107c:	ebffffe5 	bl	1018 <_Unwind_VRS_Set>
    1080:	e28dd014 	add	sp, sp, #20
    1084:	e8bd8000 	ldmfd	sp!, {pc}
    1088:	e92d4ff0 	push	{r4, r5, r6, r7, r8, r9, sl, fp, lr}
    108c:	e1a04001 	mov	r4, r1
    1090:	e594704c 	ldr	r7, [r4, #76]	; 0x4c
    1094:	e24dd024 	sub	sp, sp, #36	; 0x24
    1098:	e1a06002 	mov	r6, r2
    109c:	e2001008 	and	r1, r0, #8
    10a0:	e4972004 	ldr	r2, [r7], #4
    10a4:	e3530000 	cmp	r3, #0
    10a8:	e58d100c 	str	r1, [sp, #12]
    10ac:	e2008003 	and	r8, r0, #3
    10b0:	e58d7018 	str	r7, [sp, #24]
    10b4:	e58d3004 	str	r3, [sp, #4]
    10b8:	1a000005 	bne	10d4 <_Unwind_VRS_Set+0xbc>
    10bc:	e1a02402 	lsl	r2, r2, #8
    10c0:	e5cd301d 	strb	r3, [sp, #29]
    10c4:	e3a03003 	mov	r3, #3
    10c8:	e58d2014 	str	r2, [sp, #20]
    10cc:	e5cd301c 	strb	r3, [sp, #28]
    10d0:	ea000007 	b	10f4 <_Unwind_VRS_Set+0xdc>
    10d4:	e1a03822 	lsr	r3, r2, #16
    10d8:	e20330ff 	and	r3, r3, #255	; 0xff
    10dc:	e1a02802 	lsl	r2, r2, #16
    10e0:	e58d2014 	str	r2, [sp, #20]
    10e4:	e0877103 	add	r7, r7, r3, lsl #2
    10e8:	e3a02002 	mov	r2, #2
    10ec:	e5cd301d 	strb	r3, [sp, #29]
    10f0:	e5cd201c 	strb	r2, [sp, #28]
    10f4:	e5949050 	ldr	r9, [r4, #80]	; 0x50
    10f8:	e3580002 	cmp	r8, #2
    10fc:	05947038 	ldreq	r7, [r4, #56]	; 0x38
    1100:	e2199001 	ands	r9, r9, #1
    1104:	13a09000 	movne	r9, #0
    1108:	0a0000a4 	beq	13a0 <_Unwind_VRS_Set+0x388>
    110c:	ea0000a8 	b	13b4 <_Unwind_VRS_Set+0x39c>
    1110:	e59d2004 	ldr	r2, [sp, #4]
    1114:	e5943048 	ldr	r3, [r4, #72]	; 0x48
    1118:	e3520002 	cmp	r2, #2
    111c:	0597b004 	ldreq	fp, [r7, #4]
    1120:	11d7b0b2 	ldrhne	fp, [r7, #2]
    1124:	02875008 	addeq	r5, r7, #8
    1128:	11d7a0b0 	ldrhne	sl, [r7]
    112c:	12875004 	addne	r5, r7, #4
    1130:	e1a00006 	mov	r0, r6
    1134:	e3cb7001 	bic	r7, fp, #1
    1138:	e3a0100f 	mov	r1, #15
    113c:	e0877003 	add	r7, r7, r3
    1140:	ebffffaa 	bl	ff0 <_Unwind_VRS_Get+0x44>
    1144:	e1570000 	cmp	r7, r0
    1148:	83a00000 	movhi	r0, #0
    114c:	8a000004 	bhi	1164 <_Unwind_VRS_Set+0x14c>
    1150:	e3ca3001 	bic	r3, sl, #1
    1154:	e0877003 	add	r7, r7, r3
    1158:	e1500007 	cmp	r0, r7
    115c:	23a00000 	movcs	r0, #0
    1160:	33a00001 	movcc	r0, #1
    1164:	e20bb001 	and	fp, fp, #1
    1168:	e20aa001 	and	sl, sl, #1
    116c:	e18aa08b 	orr	sl, sl, fp, lsl #1
    1170:	e35a0001 	cmp	sl, #1
    1174:	0a000015 	beq	11d0 <_Unwind_VRS_Set+0x1b8>
    1178:	3a000002 	bcc	1188 <_Unwind_VRS_Set+0x170>
    117c:	e35a0002 	cmp	sl, #2
    1180:	1a0000a1 	bne	140c <_Unwind_VRS_Set+0x3f4>
    1184:	ea000036 	b	1264 <_Unwind_VRS_Set+0x24c>
    1188:	e3580000 	cmp	r8, #0
    118c:	03a00000 	moveq	r0, #0
    1190:	12000001 	andne	r0, r0, #1
    1194:	e3500000 	cmp	r0, #0
    1198:	e2857004 	add	r7, r5, #4
    119c:	0a000081 	beq	13a8 <_Unwind_VRS_Set+0x390>
    11a0:	e1a00005 	mov	r0, r5
    11a4:	ebfffe8f 	bl	be8 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x4>
    11a8:	e5847038 	str	r7, [r4, #56]	; 0x38
    11ac:	e1a05000 	mov	r5, r0
    11b0:	e1a00004 	mov	r0, r4
    11b4:	ebfffe7b 	bl	ba8 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x3c>
    11b8:	e3500000 	cmp	r0, #0
    11bc:	11a00006 	movne	r0, r6
    11c0:	13a0100f 	movne	r1, #15
    11c4:	11a02005 	movne	r2, r5
    11c8:	0a00008f 	beq	140c <_Unwind_VRS_Set+0x3f4>
    11cc:	ea00008b 	b	1400 <_Unwind_VRS_Set+0x3e8>
    11d0:	e3580000 	cmp	r8, #0
    11d4:	1a000016 	bne	1234 <_Unwind_VRS_Set+0x21c>
    11d8:	e3500000 	cmp	r0, #0
    11dc:	0a00001e 	beq	125c <_Unwind_VRS_Set+0x244>
    11e0:	e895000c 	ldm	r5, {r2, r3}
    11e4:	e3730002 	cmn	r3, #2
    11e8:	0a000087 	beq	140c <_Unwind_VRS_Set+0x3f4>
    11ec:	e59d1008 	ldr	r1, [sp, #8]
    11f0:	e3730001 	cmn	r3, #1
    11f4:	e58d1010 	str	r1, [sp, #16]
    11f8:	0a000009 	beq	1224 <_Unwind_VRS_Set+0x20c>
    11fc:	e3530000 	cmp	r3, #0
    1200:	10853003 	addne	r3, r5, r3
    1204:	15931004 	ldrne	r1, [r3, #4]
    1208:	01a01008 	moveq	r1, r8
    120c:	e1a00004 	mov	r0, r4
    1210:	e1a02fa2 	lsr	r2, r2, #31
    1214:	e28d3010 	add	r3, sp, #16
    1218:	ebfffe65 	bl	bb4 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x30>
    121c:	e3500000 	cmp	r0, #0
    1220:	058d0010 	streq	r0, [sp, #16]
    1224:	e59d3010 	ldr	r3, [sp, #16]
    1228:	e3530000 	cmp	r3, #0
    122c:	0a00000a 	beq	125c <_Unwind_VRS_Set+0x244>
    1230:	ea00002c 	b	12e8 <_Unwind_VRS_Set+0x2d0>
    1234:	e1a00006 	mov	r0, r6
    1238:	e3a0100d 	mov	r1, #13
    123c:	e5947020 	ldr	r7, [r4, #32]
    1240:	ebffff6a 	bl	ff0 <_Unwind_VRS_Get+0x44>
    1244:	e1570000 	cmp	r7, r0
    1248:	1a000003 	bne	125c <_Unwind_VRS_Set+0x244>
    124c:	e5943028 	ldr	r3, [r4, #40]	; 0x28
    1250:	e1550003 	cmp	r5, r3
    1254:	01a00005 	moveq	r0, r5
    1258:	0a000040 	beq	1360 <_Unwind_VRS_Set+0x348>
    125c:	e2857008 	add	r7, r5, #8
    1260:	ea000050 	b	13a8 <_Unwind_VRS_Set+0x390>
    1264:	e5957000 	ldr	r7, [r5]
    1268:	e3580000 	cmp	r8, #0
    126c:	e3c77102 	bic	r7, r7, #-2147483648	; 0x80000000
    1270:	1a000025 	bne	130c <_Unwind_VRS_Set+0x2f4>
    1274:	e3500000 	cmp	r0, #0
    1278:	0a000042 	beq	1388 <_Unwind_VRS_Set+0x370>
    127c:	e59d200c 	ldr	r2, [sp, #12]
    1280:	e3520000 	cmp	r2, #0
    1284:	13570000 	cmpne	r7, #0
    1288:	01a0b005 	moveq	fp, r5
    128c:	01a0a008 	moveq	sl, r8
    1290:	0a000012 	beq	12e0 <_Unwind_VRS_Set+0x2c8>
    1294:	ea00003b 	b	1388 <_Unwind_VRS_Set+0x370>
    1298:	e5bb1004 	ldr	r1, [fp, #4]!
    129c:	e59d3008 	ldr	r3, [sp, #8]
    12a0:	e3510000 	cmp	r1, #0
    12a4:	e28ac001 	add	ip, sl, #1
    12a8:	1791100b 	ldrne	r1, [r1, fp]
    12ac:	e58d3010 	str	r3, [sp, #16]
    12b0:	e1a00004 	mov	r0, r4
    12b4:	e3a02000 	mov	r2, #0
    12b8:	e28d3010 	add	r3, sp, #16
    12bc:	e58dc000 	str	ip, [sp]
    12c0:	ebfffe3b 	bl	bb4 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x30>
    12c4:	e59dc000 	ldr	ip, [sp]
    12c8:	e3500000 	cmp	r0, #0
    12cc:	0a000002 	beq	12dc <_Unwind_VRS_Set+0x2c4>
    12d0:	e15a0007 	cmp	sl, r7
    12d4:	1a00002b 	bne	1388 <_Unwind_VRS_Set+0x370>
    12d8:	ea000002 	b	12e8 <_Unwind_VRS_Set+0x2d0>
    12dc:	e1a0a00c 	mov	sl, ip
    12e0:	e15a0007 	cmp	sl, r7
    12e4:	1affffeb 	bne	1298 <_Unwind_VRS_Set+0x280>
    12e8:	e1a00006 	mov	r0, r6
    12ec:	e3a0100d 	mov	r1, #13
    12f0:	ebffff3e 	bl	ff0 <_Unwind_VRS_Get+0x44>
    12f4:	e59d3010 	ldr	r3, [sp, #16]
    12f8:	e5843024 	str	r3, [r4, #36]	; 0x24
    12fc:	e5845028 	str	r5, [r4, #40]	; 0x28
    1300:	e5840020 	str	r0, [r4, #32]
    1304:	e3a00006 	mov	r0, #6
    1308:	ea000040 	b	1410 <_Unwind_VRS_Set+0x3f8>
    130c:	e1a00006 	mov	r0, r6
    1310:	e3a0100d 	mov	r1, #13
    1314:	e594a020 	ldr	sl, [r4, #32]
    1318:	ebffff34 	bl	ff0 <_Unwind_VRS_Get+0x44>
    131c:	e15a0000 	cmp	sl, r0
    1320:	1a000018 	bne	1388 <_Unwind_VRS_Set+0x370>
    1324:	e5943028 	ldr	r3, [r4, #40]	; 0x28
    1328:	e1550003 	cmp	r5, r3
    132c:	1a000015 	bne	1388 <_Unwind_VRS_Set+0x370>
    1330:	e3a03004 	mov	r3, #4
    1334:	e3a01000 	mov	r1, #0
    1338:	e5843030 	str	r3, [r4, #48]	; 0x30
    133c:	e0853003 	add	r3, r5, r3
    1340:	e5847028 	str	r7, [r4, #40]	; 0x28
    1344:	e584102c 	str	r1, [r4, #44]	; 0x2c
    1348:	e5843034 	str	r3, [r4, #52]	; 0x34
    134c:	e5953000 	ldr	r3, [r5]
    1350:	e1530001 	cmp	r3, r1
    1354:	ba00000a 	blt	1384 <_Unwind_VRS_Set+0x36c>
    1358:	e2870001 	add	r0, r7, #1
    135c:	e0850100 	add	r0, r5, r0, lsl #2
    1360:	ebfffe20 	bl	be8 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x4>
    1364:	e3a0100f 	mov	r1, #15
    1368:	e1a02000 	mov	r2, r0
    136c:	e1a00006 	mov	r0, r6
    1370:	ebffff39 	bl	105c <_Unwind_VRS_Set+0x44>
    1374:	e1a00006 	mov	r0, r6
    1378:	e3a01000 	mov	r1, #0
    137c:	e1a02004 	mov	r2, r4
    1380:	ea00001e 	b	1400 <_Unwind_VRS_Set+0x3e8>
    1384:	e3a09001 	mov	r9, #1
    1388:	e5953000 	ldr	r3, [r5]
    138c:	e2877001 	add	r7, r7, #1
    1390:	e3530000 	cmp	r3, #0
    1394:	b2855004 	addlt	r5, r5, #4
    1398:	e0857107 	add	r7, r5, r7, lsl #2
    139c:	ea000001 	b	13a8 <_Unwind_VRS_Set+0x390>
    13a0:	e2842058 	add	r2, r4, #88	; 0x58
    13a4:	e58d2008 	str	r2, [sp, #8]
    13a8:	e597a000 	ldr	sl, [r7]
    13ac:	e35a0000 	cmp	sl, #0
    13b0:	1affff56 	bne	1110 <_Unwind_VRS_Set+0xf8>
    13b4:	e1a00006 	mov	r0, r6
    13b8:	e28d1014 	add	r1, sp, #20
    13bc:	eb000200 	bl	1bc4 <__gnu_unwind_execute>
    13c0:	e3500000 	cmp	r0, #0
    13c4:	1a000010 	bne	140c <_Unwind_VRS_Set+0x3f4>
    13c8:	e3590000 	cmp	r9, #0
    13cc:	03a00008 	moveq	r0, #8
    13d0:	0a00000e 	beq	1410 <_Unwind_VRS_Set+0x3f8>
    13d4:	e3a0100f 	mov	r1, #15
    13d8:	e1a00006 	mov	r0, r6
    13dc:	ebffff03 	bl	ff0 <_Unwind_VRS_Get+0x44>
    13e0:	e3a0100e 	mov	r1, #14
    13e4:	e1a02000 	mov	r2, r0
    13e8:	e1a00006 	mov	r0, r6
    13ec:	ebffff1a 	bl	105c <_Unwind_VRS_Set+0x44>
    13f0:	e59f2020 	ldr	r2, [pc, #32]	; 1418 <_Unwind_VRS_Set+0x400>
    13f4:	e1a00006 	mov	r0, r6
    13f8:	e3a0100f 	mov	r1, #15
    13fc:	e79f2002 	ldr	r2, [pc, r2]
    1400:	ebffff15 	bl	105c <_Unwind_VRS_Set+0x44>
    1404:	e3a00007 	mov	r0, #7
    1408:	ea000000 	b	1410 <_Unwind_VRS_Set+0x3f8>
    140c:	e3a00009 	mov	r0, #9
    1410:	e28dd024 	add	sp, sp, #36	; 0x24
    1414:	e8bd8ff0 	pop	{r4, r5, r6, r7, r8, r9, sl, fp, pc}
    1418:	00002bd0 	ldrdeq	r2, [r0], -r0

0000141c <__aeabi_unwind_cpp_pr2>:
    141c:	e3a03002 	mov	r3, #2
    1420:	eaffff18 	b	1088 <_Unwind_VRS_Set+0x70>

00001424 <__aeabi_unwind_cpp_pr1>:
    1424:	e3a03001 	mov	r3, #1
    1428:	eaffff16 	b	1088 <_Unwind_VRS_Set+0x70>

0000142c <__aeabi_unwind_cpp_pr0>:
    142c:	e3a03000 	mov	r3, #0
    1430:	eaffff14 	b	1088 <_Unwind_VRS_Set+0x70>

00001434 <_Unwind_VRS_Pop>:
    1434:	e92d45f0 	push	{r4, r5, r6, r7, r8, sl, lr}
    1438:	e1a04000 	mov	r4, r0
    143c:	e24ddf67 	sub	sp, sp, #412	; 0x19c
    1440:	e1a05002 	mov	r5, r2
    1444:	e3510004 	cmp	r1, #4
    1448:	908ff101 	addls	pc, pc, r1, lsl #2
    144c:	ea0000ca 	b	177c <_Unwind_VRS_Pop+0x348>
    1450:	ea000005 	b	146c <_Unwind_VRS_Pop+0x38>
    1454:	ea000015 	b	14b0 <_Unwind_VRS_Pop+0x7c>
    1458:	ea000001 	b	1464 <_Unwind_VRS_Pop+0x30>
    145c:	ea00008c 	b	1694 <_Unwind_VRS_Pop+0x260>
    1460:	ea0000ac 	b	1718 <_Unwind_VRS_Pop+0x2e4>
    1464:	e3a07001 	mov	r7, #1
    1468:	ea0000c4 	b	1780 <_Unwind_VRS_Pop+0x34c>
    146c:	e3530000 	cmp	r3, #0
    1470:	1a0000c1 	bne	177c <_Unwind_VRS_Pop+0x348>
    1474:	e1a07802 	lsl	r7, r2, #16
    1478:	e5902038 	ldr	r2, [r0, #56]	; 0x38
    147c:	e1a07827 	lsr	r7, r7, #16
    1480:	e3a01001 	mov	r1, #1
    1484:	e0170311 	ands	r0, r7, r1, lsl r3
    1488:	10840103 	addne	r0, r4, r3, lsl #2
    148c:	1492c004 	ldrne	ip, [r2], #4
    1490:	e2833001 	add	r3, r3, #1
    1494:	1580c004 	strne	ip, [r0, #4]
    1498:	e3530010 	cmp	r3, #16
    149c:	1afffff8 	bne	1484 <_Unwind_VRS_Pop+0x50>
    14a0:	e2177a02 	ands	r7, r7, #8192	; 0x2000
    14a4:	05842038 	streq	r2, [r4, #56]	; 0x38
    14a8:	0a0000b4 	beq	1780 <_Unwind_VRS_Pop+0x34c>
    14ac:	ea0000b0 	b	1774 <_Unwind_VRS_Pop+0x340>
    14b0:	e2531005 	subs	r1, r3, #5
    14b4:	13a01001 	movne	r1, #1
    14b8:	e3530001 	cmp	r3, #1
    14bc:	13530005 	cmpne	r3, #5
    14c0:	1a0000ad 	bne	177c <_Unwind_VRS_Pop+0x348>
    14c4:	e1a05802 	lsl	r5, r2, #16
    14c8:	e3530001 	cmp	r3, #1
    14cc:	e1a06822 	lsr	r6, r2, #16
    14d0:	e1a05825 	lsr	r5, r5, #16
    14d4:	e0852006 	add	r2, r5, r6
    14d8:	13a00020 	movne	r0, #32
    14dc:	03a00010 	moveq	r0, #16
    14e0:	e1520000 	cmp	r2, r0
    14e4:	8a0000a4 	bhi	177c <_Unwind_VRS_Pop+0x348>
    14e8:	e2430001 	sub	r0, r3, #1
    14ec:	e2708000 	rsbs	r8, r0, #0
    14f0:	e0a88000 	adc	r8, r8, r0
    14f4:	e356000f 	cmp	r6, #15
    14f8:	93a0a000 	movls	sl, #0
    14fc:	83a0a001 	movhi	sl, #1
    1500:	e11a0008 	tst	sl, r8
    1504:	1a00009c 	bne	177c <_Unwind_VRS_Pop+0x348>
    1508:	e35a0000 	cmp	sl, #0
    150c:	11a0a005 	movne	sl, r5
    1510:	1a000001 	bne	151c <_Unwind_VRS_Pop+0xe8>
    1514:	e3520010 	cmp	r2, #16
    1518:	8242a010 	subhi	sl, r2, #16
    151c:	e29a7000 	adds	r7, sl, #0
    1520:	13a07001 	movne	r7, #1
    1524:	e1170001 	tst	r7, r1
    1528:	1a000093 	bne	177c <_Unwind_VRS_Pop+0x348>
    152c:	e356000f 	cmp	r6, #15
    1530:	8a00000e 	bhi	1570 <_Unwind_VRS_Pop+0x13c>
    1534:	e5942000 	ldr	r2, [r4]
    1538:	e3120001 	tst	r2, #1
    153c:	0a00000b 	beq	1570 <_Unwind_VRS_Pop+0x13c>
    1540:	e3c21001 	bic	r1, r2, #1
    1544:	e1a00004 	mov	r0, r4
    1548:	e3530005 	cmp	r3, #5
    154c:	e4801048 	str	r1, [r0], #72	; 0x48
    1550:	1a000003 	bne	1564 <_Unwind_VRS_Pop+0x130>
    1554:	e3811002 	orr	r1, r1, #2
    1558:	e5841000 	str	r1, [r4]
    155c:	eb000123 	bl	19f0 <__gnu_Unwind_Save_VFP_D>
    1560:	ea000002 	b	1570 <_Unwind_VRS_Pop+0x13c>
    1564:	e3c22003 	bic	r2, r2, #3
    1568:	e5842000 	str	r2, [r4]
    156c:	eb00011b 	bl	19e0 <__gnu_Unwind_Save_VFP>
    1570:	e3570000 	cmp	r7, #0
    1574:	0a000006 	beq	1594 <_Unwind_VRS_Pop+0x160>
    1578:	e5943000 	ldr	r3, [r4]
    157c:	e3130004 	tst	r3, #4
    1580:	0a000003 	beq	1594 <_Unwind_VRS_Pop+0x160>
    1584:	e3c33004 	bic	r3, r3, #4
    1588:	e1a00004 	mov	r0, r4
    158c:	e48030d0 	str	r3, [r0], #208	; 0xd0
    1590:	eb00011a 	bl	1a00 <__gnu_Unwind_Save_VFP_D_16_to_31>
    1594:	e3580000 	cmp	r8, #0
    1598:	0a000004 	beq	15b0 <_Unwind_VRS_Pop+0x17c>
    159c:	e28d0e11 	add	r0, sp, #272	; 0x110
    15a0:	eb00010e 	bl	19e0 <__gnu_Unwind_Save_VFP>
    15a4:	e3570000 	cmp	r7, #0
    15a8:	1a000008 	bne	15d0 <_Unwind_VRS_Pop+0x19c>
    15ac:	ea000008 	b	15d4 <_Unwind_VRS_Pop+0x1a0>
    15b0:	e356000f 	cmp	r6, #15
    15b4:	8a000001 	bhi	15c0 <_Unwind_VRS_Pop+0x18c>
    15b8:	e28d0e11 	add	r0, sp, #272	; 0x110
    15bc:	eb00010b 	bl	19f0 <__gnu_Unwind_Save_VFP_D>
    15c0:	e3570000 	cmp	r7, #0
    15c4:	0a000002 	beq	15d4 <_Unwind_VRS_Pop+0x1a0>
    15c8:	e28d0010 	add	r0, sp, #16
    15cc:	eb00010b 	bl	1a00 <__gnu_Unwind_Save_VFP_D_16_to_31>
    15d0:	e2665010 	rsb	r5, r6, #16
    15d4:	e5941038 	ldr	r1, [r4, #56]	; 0x38
    15d8:	e3550000 	cmp	r5, #0
    15dc:	e1a03001 	mov	r3, r1
    15e0:	da000009 	ble	160c <_Unwind_VRS_Pop+0x1d8>
    15e4:	e28d2e11 	add	r2, sp, #272	; 0x110
    15e8:	e1a05085 	lsl	r5, r5, #1
    15ec:	e0820186 	add	r0, r2, r6, lsl #3
    15f0:	e1a02005 	mov	r2, r5
    15f4:	ea000001 	b	1600 <_Unwind_VRS_Pop+0x1cc>
    15f8:	e491c004 	ldr	ip, [r1], #4
    15fc:	e480c004 	str	ip, [r0], #4
    1600:	e2522001 	subs	r2, r2, #1
    1604:	2afffffb 	bcs	15f8 <_Unwind_VRS_Pop+0x1c4>
    1608:	e0833105 	add	r3, r3, r5, lsl #2
    160c:	e3570000 	cmp	r7, #0
    1610:	0a00000e 	beq	1650 <_Unwind_VRS_Pop+0x21c>
    1614:	e28d1f66 	add	r1, sp, #408	; 0x198
    1618:	e3560010 	cmp	r6, #16
    161c:	21a00006 	movcs	r0, r6
    1620:	33a00010 	movcc	r0, #16
    1624:	e0810180 	add	r0, r1, r0, lsl #3
    1628:	e1a0a08a 	lsl	sl, sl, #1
    162c:	e2400f82 	sub	r0, r0, #520	; 0x208
    1630:	e1a01003 	mov	r1, r3
    1634:	e1a0200a 	mov	r2, sl
    1638:	ea000001 	b	1644 <_Unwind_VRS_Pop+0x210>
    163c:	e491c004 	ldr	ip, [r1], #4
    1640:	e480c004 	str	ip, [r0], #4
    1644:	e2522001 	subs	r2, r2, #1
    1648:	2afffffb 	bcs	163c <_Unwind_VRS_Pop+0x208>
    164c:	e083310a 	add	r3, r3, sl, lsl #2
    1650:	e3580000 	cmp	r8, #0
    1654:	12833004 	addne	r3, r3, #4
    1658:	e3580000 	cmp	r8, #0
    165c:	e5843038 	str	r3, [r4, #56]	; 0x38
    1660:	0a000002 	beq	1670 <_Unwind_VRS_Pop+0x23c>
    1664:	e28d0e11 	add	r0, sp, #272	; 0x110
    1668:	eb0000da 	bl	19d8 <__gnu_Unwind_Restore_VFP>
    166c:	ea000040 	b	1774 <_Unwind_VRS_Pop+0x340>
    1670:	e356000f 	cmp	r6, #15
    1674:	8a000001 	bhi	1680 <_Unwind_VRS_Pop+0x24c>
    1678:	e28d0e11 	add	r0, sp, #272	; 0x110
    167c:	eb0000d9 	bl	19e8 <__gnu_Unwind_Restore_VFP_D>
    1680:	e3570000 	cmp	r7, #0
    1684:	0a00003d 	beq	1780 <_Unwind_VRS_Pop+0x34c>
    1688:	e28d0010 	add	r0, sp, #16
    168c:	eb0000d9 	bl	19f8 <__gnu_Unwind_Restore_VFP_D_16_to_31>
    1690:	ea000037 	b	1774 <_Unwind_VRS_Pop+0x340>
    1694:	e3530003 	cmp	r3, #3
    1698:	1a000037 	bne	177c <_Unwind_VRS_Pop+0x348>
    169c:	e1a05802 	lsl	r5, r2, #16
    16a0:	e1a06822 	lsr	r6, r2, #16
    16a4:	e1a05825 	lsr	r5, r5, #16
    16a8:	e0853006 	add	r3, r5, r6
    16ac:	e3530010 	cmp	r3, #16
    16b0:	8a000031 	bhi	177c <_Unwind_VRS_Pop+0x348>
    16b4:	e5903000 	ldr	r3, [r0]
    16b8:	e3130008 	tst	r3, #8
    16bc:	0a000002 	beq	16cc <_Unwind_VRS_Pop+0x298>
    16c0:	e3c33008 	bic	r3, r3, #8
    16c4:	e48031b0 	str	r3, [r0], #432	; 0x1b0
    16c8:	eb0000df 	bl	1a4c <__gnu_Unwind_Save_WMMXD>
    16cc:	e28d0090 	add	r0, sp, #144	; 0x90
    16d0:	eb0000dd 	bl	1a4c <__gnu_Unwind_Save_WMMXD>
    16d4:	e5943038 	ldr	r3, [r4, #56]	; 0x38
    16d8:	e28d0090 	add	r0, sp, #144	; 0x90
    16dc:	e1a05085 	lsl	r5, r5, #1
    16e0:	e1a02003 	mov	r2, r3
    16e4:	e0806186 	add	r6, r0, r6, lsl #3
    16e8:	e1a07005 	mov	r7, r5
    16ec:	ea000002 	b	16fc <_Unwind_VRS_Pop+0x2c8>
    16f0:	e4931004 	ldr	r1, [r3], #4
    16f4:	e2477001 	sub	r7, r7, #1
    16f8:	e4861004 	str	r1, [r6], #4
    16fc:	e3570000 	cmp	r7, #0
    1700:	1afffffa 	bne	16f0 <_Unwind_VRS_Pop+0x2bc>
    1704:	e0825105 	add	r5, r2, r5, lsl #2
    1708:	e5845038 	str	r5, [r4, #56]	; 0x38
    170c:	e28d0090 	add	r0, sp, #144	; 0x90
    1710:	eb0000bc 	bl	1a08 <__gnu_Unwind_Restore_WMMXD>
    1714:	ea000019 	b	1780 <_Unwind_VRS_Pop+0x34c>
    1718:	e3520010 	cmp	r2, #16
    171c:	93530000 	cmpls	r3, #0
    1720:	1a000015 	bne	177c <_Unwind_VRS_Pop+0x348>
    1724:	e5903000 	ldr	r3, [r0]
    1728:	e3130010 	tst	r3, #16
    172c:	0a000002 	beq	173c <_Unwind_VRS_Pop+0x308>
    1730:	e3c33010 	bic	r3, r3, #16
    1734:	e4803230 	str	r3, [r0], #560	; 0x230
    1738:	eb0000d9 	bl	1aa4 <__gnu_Unwind_Save_WMMXC>
    173c:	e1a0000d 	mov	r0, sp
    1740:	eb0000d7 	bl	1aa4 <__gnu_Unwind_Save_WMMXC>
    1744:	e5942038 	ldr	r2, [r4, #56]	; 0x38
    1748:	e3a03000 	mov	r3, #0
    174c:	e3a01001 	mov	r1, #1
    1750:	e0150311 	ands	r0, r5, r1, lsl r3
    1754:	14920004 	ldrne	r0, [r2], #4
    1758:	178d0103 	strne	r0, [sp, r3, lsl #2]
    175c:	e2833001 	add	r3, r3, #1
    1760:	e3530004 	cmp	r3, #4
    1764:	1afffff9 	bne	1750 <_Unwind_VRS_Pop+0x31c>
    1768:	e5842038 	str	r2, [r4, #56]	; 0x38
    176c:	e1a0000d 	mov	r0, sp
    1770:	eb0000c6 	bl	1a90 <__gnu_Unwind_Restore_WMMXC>
    1774:	e3a07000 	mov	r7, #0
    1778:	ea000000 	b	1780 <_Unwind_VRS_Pop+0x34c>
    177c:	e3a07002 	mov	r7, #2
    1780:	e1a00007 	mov	r0, r7
    1784:	e28ddf67 	add	sp, sp, #412	; 0x19c
    1788:	e8bd85f0 	pop	{r4, r5, r6, r7, r8, sl, pc}

0000178c <_Unwind_GetCFA>:
    178c:	e5900044 	ldr	r0, [r0, #68]	; 0x44
    1790:	e12fff1e 	bx	lr

00001794 <__gnu_Unwind_RaiseException>:
    1794:	e92d40f0 	push	{r4, r5, r6, r7, lr}
    1798:	e591303c 	ldr	r3, [r1, #60]	; 0x3c
    179c:	e281e004 	add	lr, r1, #4
    17a0:	e5813040 	str	r3, [r1, #64]	; 0x40
    17a4:	e1a05000 	mov	r5, r0
    17a8:	e1a04001 	mov	r4, r1
    17ac:	e8be000f 	ldm	lr!, {r0, r1, r2, r3}
    17b0:	e24ddf91 	sub	sp, sp, #580	; 0x244
    17b4:	e28dc004 	add	ip, sp, #4
    17b8:	e8ac000f 	stmia	ip!, {r0, r1, r2, r3}
    17bc:	e8be000f 	ldm	lr!, {r0, r1, r2, r3}
    17c0:	e8ac000f 	stmia	ip!, {r0, r1, r2, r3}
    17c4:	e8be000f 	ldm	lr!, {r0, r1, r2, r3}
    17c8:	e8ac000f 	stmia	ip!, {r0, r1, r2, r3}
    17cc:	e89e000f 	ldm	lr, {r0, r1, r2, r3}
    17d0:	e28d6d09 	add	r6, sp, #576	; 0x240
    17d4:	e88c000f 	stm	ip, {r0, r1, r2, r3}
    17d8:	e3e03000 	mvn	r3, #0
    17dc:	e5263240 	str	r3, [r6, #-576]!	; 0x240
    17e0:	e1a00005 	mov	r0, r5
    17e4:	e59d1040 	ldr	r1, [sp, #64]	; 0x40
    17e8:	ebfffd04 	bl	c00 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1c>
    17ec:	e3500000 	cmp	r0, #0
    17f0:	1a00000d 	bne	182c <__gnu_Unwind_RaiseException+0x98>
    17f4:	e5953010 	ldr	r3, [r5, #16]
    17f8:	e1a01005 	mov	r1, r5
    17fc:	e1a0200d 	mov	r2, sp
    1800:	e12fff33 	blx	r3
    1804:	e3500008 	cmp	r0, #8
    1808:	e1a07000 	mov	r7, r0
    180c:	0afffff3 	beq	17e0 <__gnu_Unwind_RaiseException+0x4c>
    1810:	e1a0000d 	mov	r0, sp
    1814:	ebfffd6e 	bl	dd4 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1f0>
    1818:	e3570006 	cmp	r7, #6
    181c:	1a000002 	bne	182c <__gnu_Unwind_RaiseException+0x98>
    1820:	e1a00005 	mov	r0, r5
    1824:	e1a01004 	mov	r1, r4
    1828:	ebfffdc9 	bl	f54 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x370>
    182c:	e3a00009 	mov	r0, #9
    1830:	e28ddf91 	add	sp, sp, #580	; 0x244
    1834:	e8bd80f0 	pop	{r4, r5, r6, r7, pc}

00001838 <__gnu_Unwind_ForcedUnwind>:
    1838:	e5802018 	str	r2, [r0, #24]
    183c:	e593203c 	ldr	r2, [r3, #60]	; 0x3c
    1840:	e580100c 	str	r1, [r0, #12]
    1844:	e5832040 	str	r2, [r3, #64]	; 0x40
    1848:	e1a01003 	mov	r1, r3
    184c:	e3a02000 	mov	r2, #0
    1850:	eafffd7a 	b	e40 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x25c>

00001854 <__gnu_Unwind_Resume>:
    1854:	e92d4038 	push	{r3, r4, r5, lr}
    1858:	e5903014 	ldr	r3, [r0, #20]
    185c:	e5813040 	str	r3, [r1, #64]	; 0x40
    1860:	e590300c 	ldr	r3, [r0, #12]
    1864:	e1a04000 	mov	r4, r0
    1868:	e3530000 	cmp	r3, #0
    186c:	e1a05001 	mov	r5, r1
    1870:	0a000002 	beq	1880 <__gnu_Unwind_Resume+0x2c>
    1874:	e3a02001 	mov	r2, #1
    1878:	ebfffd70 	bl	e40 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x25c>
    187c:	ea00000e 	b	18bc <__gnu_Unwind_Resume+0x68>
    1880:	e5903010 	ldr	r3, [r0, #16]
    1884:	e1a01004 	mov	r1, r4
    1888:	e3a00002 	mov	r0, #2
    188c:	e1a02005 	mov	r2, r5
    1890:	e12fff33 	blx	r3
    1894:	e3500007 	cmp	r0, #7
    1898:	0a000002 	beq	18a8 <__gnu_Unwind_Resume+0x54>
    189c:	e3500008 	cmp	r0, #8
    18a0:	1a000005 	bne	18bc <__gnu_Unwind_Resume+0x68>
    18a4:	ea000001 	b	18b0 <__gnu_Unwind_Resume+0x5c>
    18a8:	e2850004 	add	r0, r5, #4
    18ac:	eb000044 	bl	19c4 <__restore_core_regs>
    18b0:	e1a00004 	mov	r0, r4
    18b4:	e1a01005 	mov	r1, r5
    18b8:	ebfffda5 	bl	f54 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x370>
    18bc:	ebfffcb6 	bl	b9c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x48>

000018c0 <__gnu_Unwind_Resume_or_Rethrow>:
    18c0:	e590200c 	ldr	r2, [r0, #12]
    18c4:	e3520000 	cmp	r2, #0
    18c8:	1a000000 	bne	18d0 <__gnu_Unwind_Resume_or_Rethrow+0x10>
    18cc:	eaffffb0 	b	1794 <__gnu_Unwind_RaiseException>
    18d0:	e591203c 	ldr	r2, [r1, #60]	; 0x3c
    18d4:	e5812040 	str	r2, [r1, #64]	; 0x40
    18d8:	e3a02000 	mov	r2, #0
    18dc:	eafffd57 	b	e40 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x25c>

000018e0 <_Unwind_Complete>:
    18e0:	e12fff1e 	bx	lr

000018e4 <_Unwind_DeleteException>:
    18e4:	e92d4008 	push	{r3, lr}
    18e8:	e5903008 	ldr	r3, [r0, #8]
    18ec:	e1a01000 	mov	r1, r0
    18f0:	e3530000 	cmp	r3, #0
    18f4:	08bd8008 	popeq	{r3, pc}
    18f8:	e3a00001 	mov	r0, #1
    18fc:	e12fff33 	blx	r3
    1900:	e8bd8008 	pop	{r3, pc}

00001904 <__gnu_Unwind_Backtrace>:
    1904:	e92d4070 	push	{r4, r5, r6, lr}
    1908:	e592303c 	ldr	r3, [r2, #60]	; 0x3c
    190c:	e282e004 	add	lr, r2, #4
    1910:	e5823040 	str	r3, [r2, #64]	; 0x40
    1914:	e1a05000 	mov	r5, r0
    1918:	e1a04001 	mov	r4, r1
    191c:	e8be000f 	ldm	lr!, {r0, r1, r2, r3}
    1920:	e24ddfa6 	sub	sp, sp, #664	; 0x298
    1924:	e28dc05c 	add	ip, sp, #92	; 0x5c
    1928:	e8ac000f 	stmia	ip!, {r0, r1, r2, r3}
    192c:	e8be000f 	ldm	lr!, {r0, r1, r2, r3}
    1930:	e8ac000f 	stmia	ip!, {r0, r1, r2, r3}
    1934:	e8be000f 	ldm	lr!, {r0, r1, r2, r3}
    1938:	e8ac000f 	stmia	ip!, {r0, r1, r2, r3}
    193c:	e89e000f 	ldm	lr, {r0, r1, r2, r3}
    1940:	e88c000f 	stm	ip, {r0, r1, r2, r3}
    1944:	e3e03000 	mvn	r3, #0
    1948:	e58d3058 	str	r3, [sp, #88]	; 0x58
    194c:	e1a0000d 	mov	r0, sp
    1950:	e59d1098 	ldr	r1, [sp, #152]	; 0x98
    1954:	ebfffca9 	bl	c00 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1c>
    1958:	e3500000 	cmp	r0, #0
    195c:	1a000012 	bne	19ac <__gnu_Unwind_Backtrace+0xa8>
    1960:	e28d0058 	add	r0, sp, #88	; 0x58
    1964:	e3a0100c 	mov	r1, #12
    1968:	e1a0200d 	mov	r2, sp
    196c:	ebfffdba 	bl	105c <_Unwind_VRS_Set+0x44>
    1970:	e28d0058 	add	r0, sp, #88	; 0x58
    1974:	e1a01004 	mov	r1, r4
    1978:	e12fff35 	blx	r5
    197c:	e3500000 	cmp	r0, #0
    1980:	1a000009 	bne	19ac <__gnu_Unwind_Backtrace+0xa8>
    1984:	e3a00008 	mov	r0, #8
    1988:	e1a0100d 	mov	r1, sp
    198c:	e28d2058 	add	r2, sp, #88	; 0x58
    1990:	e59d3010 	ldr	r3, [sp, #16]
    1994:	e12fff33 	blx	r3
    1998:	e3500009 	cmp	r0, #9
    199c:	13500005 	cmpne	r0, #5
    19a0:	e1a06000 	mov	r6, r0
    19a4:	1affffe8 	bne	194c <__gnu_Unwind_Backtrace+0x48>
    19a8:	ea000000 	b	19b0 <__gnu_Unwind_Backtrace+0xac>
    19ac:	e3a06009 	mov	r6, #9
    19b0:	e28d0058 	add	r0, sp, #88	; 0x58
    19b4:	ebfffd06 	bl	dd4 <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject+0x1f0>
    19b8:	e1a00006 	mov	r0, r6
    19bc:	e28ddfa6 	add	sp, sp, #664	; 0x298
    19c0:	e8bd8070 	pop	{r4, r5, r6, pc}

000019c4 <__restore_core_regs>:
    19c4:	e2801034 	add	r1, r0, #52	; 0x34
    19c8:	e8910038 	ldm	r1, {r3, r4, r5}
    19cc:	e92d0038 	push	{r3, r4, r5}
    19d0:	e8900fff 	ldm	r0, {r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, sl, fp}
    19d4:	e89de000 	ldm	sp, {sp, lr, pc}

000019d8 <__gnu_Unwind_Restore_VFP>:
    19d8:	ec900b21 	fldmiax	r0, {d0-d15}	;@ Deprecated
    19dc:	e12fff1e 	bx	lr

000019e0 <__gnu_Unwind_Save_VFP>:
    19e0:	ec800b21 	fstmiax	r0, {d0-d15}	;@ Deprecated
    19e4:	e12fff1e 	bx	lr

000019e8 <__gnu_Unwind_Restore_VFP_D>:
    19e8:	ec900b20 	vldmia	r0, {d0-d15}
    19ec:	e12fff1e 	bx	lr

000019f0 <__gnu_Unwind_Save_VFP_D>:
    19f0:	ec800b20 	vstmia	r0, {d0-d15}
    19f4:	e12fff1e 	bx	lr

000019f8 <__gnu_Unwind_Restore_VFP_D_16_to_31>:
    19f8:	ecd00b20 	vldmia	r0, {d16-d31}
    19fc:	e12fff1e 	bx	lr

00001a00 <__gnu_Unwind_Save_VFP_D_16_to_31>:
    1a00:	ecc00b20 	vstmia	r0, {d16-d31}
    1a04:	e12fff1e 	bx	lr

00001a08 <__gnu_Unwind_Restore_WMMXD>:
    1a08:	ecf00102 	ldfe	f0, [r0], #8
    1a0c:	ecf01102 	ldfe	f1, [r0], #8
    1a10:	ecf02102 	ldfe	f2, [r0], #8
    1a14:	ecf03102 	ldfe	f3, [r0], #8
    1a18:	ecf04102 	ldfe	f4, [r0], #8
    1a1c:	ecf05102 	ldfe	f5, [r0], #8
    1a20:	ecf06102 	ldfe	f6, [r0], #8
    1a24:	ecf07102 	ldfe	f7, [r0], #8
    1a28:	ecf08102 	ldfp	f0, [r0], #8
    1a2c:	ecf09102 	ldfp	f1, [r0], #8
    1a30:	ecf0a102 	ldfp	f2, [r0], #8
    1a34:	ecf0b102 	ldfp	f3, [r0], #8
    1a38:	ecf0c102 	ldfp	f4, [r0], #8
    1a3c:	ecf0d102 	ldfp	f5, [r0], #8
    1a40:	ecf0e102 	ldfp	f6, [r0], #8
    1a44:	ecf0f102 	ldfp	f7, [r0], #8
    1a48:	e12fff1e 	bx	lr

00001a4c <__gnu_Unwind_Save_WMMXD>:
    1a4c:	ece00102 	stfe	f0, [r0], #8
    1a50:	ece01102 	stfe	f1, [r0], #8
    1a54:	ece02102 	stfe	f2, [r0], #8
    1a58:	ece03102 	stfe	f3, [r0], #8
    1a5c:	ece04102 	stfe	f4, [r0], #8
    1a60:	ece05102 	stfe	f5, [r0], #8
    1a64:	ece06102 	stfe	f6, [r0], #8
    1a68:	ece07102 	stfe	f7, [r0], #8
    1a6c:	ece08102 	stfp	f0, [r0], #8
    1a70:	ece09102 	stfp	f1, [r0], #8
    1a74:	ece0a102 	stfp	f2, [r0], #8
    1a78:	ece0b102 	stfp	f3, [r0], #8
    1a7c:	ece0c102 	stfp	f4, [r0], #8
    1a80:	ece0d102 	stfp	f5, [r0], #8
    1a84:	ece0e102 	stfp	f6, [r0], #8
    1a88:	ece0f102 	stfp	f7, [r0], #8
    1a8c:	e12fff1e 	bx	lr

00001a90 <__gnu_Unwind_Restore_WMMXC>:
    1a90:	fcb08101 	ldc2	1, cr8, [r0], #4
    1a94:	fcb09101 	ldc2	1, cr9, [r0], #4
    1a98:	fcb0a101 	ldc2	1, cr10, [r0], #4
    1a9c:	fcb0b101 	ldc2	1, cr11, [r0], #4
    1aa0:	e12fff1e 	bx	lr

00001aa4 <__gnu_Unwind_Save_WMMXC>:
    1aa4:	fca08101 	stc2	1, cr8, [r0], #4
    1aa8:	fca09101 	stc2	1, cr9, [r0], #4
    1aac:	fca0a101 	stc2	1, cr10, [r0], #4
    1ab0:	fca0b101 	stc2	1, cr11, [r0], #4
    1ab4:	e12fff1e 	bx	lr

00001ab8 <_Unwind_RaiseException>:
    1ab8:	e92de000 	push	{sp, lr, pc}
    1abc:	e92d1fff 	push	{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, sl, fp, ip}
    1ac0:	e3a03000 	mov	r3, #0
    1ac4:	e92d000c 	push	{r2, r3}
    1ac8:	e28d1004 	add	r1, sp, #4
    1acc:	ebffff30 	bl	1794 <__gnu_Unwind_RaiseException>
    1ad0:	e59de040 	ldr	lr, [sp, #64]	; 0x40
    1ad4:	e28dd048 	add	sp, sp, #72	; 0x48
    1ad8:	e12fff1e 	bx	lr

00001adc <_Unwind_Resume>:
    1adc:	e92de000 	push	{sp, lr, pc}
    1ae0:	e92d1fff 	push	{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, sl, fp, ip}
    1ae4:	e3a03000 	mov	r3, #0
    1ae8:	e92d000c 	push	{r2, r3}
    1aec:	e28d1004 	add	r1, sp, #4
    1af0:	ebffff57 	bl	1854 <__gnu_Unwind_Resume>
    1af4:	e59de040 	ldr	lr, [sp, #64]	; 0x40
    1af8:	e28dd048 	add	sp, sp, #72	; 0x48
    1afc:	e12fff1e 	bx	lr

00001b00 <_Unwind_Resume_or_Rethrow>:
    1b00:	e92de000 	push	{sp, lr, pc}
    1b04:	e92d1fff 	push	{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, sl, fp, ip}
    1b08:	e3a03000 	mov	r3, #0
    1b0c:	e92d000c 	push	{r2, r3}
    1b10:	e28d1004 	add	r1, sp, #4
    1b14:	ebffff69 	bl	18c0 <__gnu_Unwind_Resume_or_Rethrow>
    1b18:	e59de040 	ldr	lr, [sp, #64]	; 0x40
    1b1c:	e28dd048 	add	sp, sp, #72	; 0x48
    1b20:	e12fff1e 	bx	lr

00001b24 <_Unwind_ForcedUnwind>:
    1b24:	e92de000 	push	{sp, lr, pc}
    1b28:	e92d1fff 	push	{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, sl, fp, ip}
    1b2c:	e3a03000 	mov	r3, #0
    1b30:	e92d000c 	push	{r2, r3}
    1b34:	e28d3004 	add	r3, sp, #4
    1b38:	ebffff3e 	bl	1838 <__gnu_Unwind_ForcedUnwind>
    1b3c:	e59de040 	ldr	lr, [sp, #64]	; 0x40
    1b40:	e28dd048 	add	sp, sp, #72	; 0x48
    1b44:	e12fff1e 	bx	lr

00001b48 <_Unwind_Backtrace>:
    1b48:	e92de000 	push	{sp, lr, pc}
    1b4c:	e92d1fff 	push	{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, sl, fp, ip}
    1b50:	e3a03000 	mov	r3, #0
    1b54:	e92d000c 	push	{r2, r3}
    1b58:	e28d2004 	add	r2, sp, #4
    1b5c:	ebffff68 	bl	1904 <__gnu_Unwind_Backtrace>
    1b60:	e59de040 	ldr	lr, [sp, #64]	; 0x40
    1b64:	e28dd048 	add	sp, sp, #72	; 0x48
    1b68:	e12fff1e 	bx	lr
    1b6c:	e5d02008 	ldrb	r2, [r0, #8]
    1b70:	e1a03000 	mov	r3, r0
    1b74:	e3520000 	cmp	r2, #0
    1b78:	12422001 	subne	r2, r2, #1
    1b7c:	1a000008 	bne	1ba4 <_Unwind_Backtrace+0x5c>
    1b80:	e5d02009 	ldrb	r2, [r0, #9]
    1b84:	e3520000 	cmp	r2, #0
    1b88:	0a00000b 	beq	1bbc <_Unwind_Backtrace+0x74>
    1b8c:	e2422001 	sub	r2, r2, #1
    1b90:	e5c02009 	strb	r2, [r0, #9]
    1b94:	e5902004 	ldr	r2, [r0, #4]
    1b98:	e4921004 	ldr	r1, [r2], #4
    1b9c:	e8800006 	stm	r0, {r1, r2}
    1ba0:	e3a02003 	mov	r2, #3
    1ba4:	e5c32008 	strb	r2, [r3, #8]
    1ba8:	e5932000 	ldr	r2, [r3]
    1bac:	e1a00c22 	lsr	r0, r2, #24
    1bb0:	e1a02402 	lsl	r2, r2, #8
    1bb4:	e5832000 	str	r2, [r3]
    1bb8:	e12fff1e 	bx	lr
    1bbc:	e3a000b0 	mov	r0, #176	; 0xb0
    1bc0:	e12fff1e 	bx	lr

00001bc4 <__gnu_unwind_execute>:
    1bc4:	e92d47ff 	push	{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, sl, lr}
    1bc8:	e1a05000 	mov	r5, r0
    1bcc:	e1a06001 	mov	r6, r1
    1bd0:	e3a07000 	mov	r7, #0
    1bd4:	e28da00c 	add	sl, sp, #12
    1bd8:	e3a09eff 	mov	r9, #4080	; 0xff0
    1bdc:	e1a00006 	mov	r0, r6
    1be0:	ebffffe1 	bl	1b6c <_Unwind_Backtrace+0x24>
    1be4:	e35000b0 	cmp	r0, #176	; 0xb0
    1be8:	e1a04000 	mov	r4, r0
    1bec:	1a000011 	bne	1c38 <__gnu_unwind_execute+0x74>
    1bf0:	e3570000 	cmp	r7, #0
    1bf4:	13a00000 	movne	r0, #0
    1bf8:	1a0000d4 	bne	1f50 <__gnu_unwind_execute+0x38c>
    1bfc:	e28d400c 	add	r4, sp, #12
    1c00:	e1a01007 	mov	r1, r7
    1c04:	e3a0200e 	mov	r2, #14
    1c08:	e1a03007 	mov	r3, r7
    1c0c:	e1a00005 	mov	r0, r5
    1c10:	e58d4000 	str	r4, [sp]
    1c14:	ebfffce4 	bl	fac <_Unwind_VRS_Get>
    1c18:	e1a00005 	mov	r0, r5
    1c1c:	e1a01007 	mov	r1, r7
    1c20:	e3a0200f 	mov	r2, #15
    1c24:	e1a03007 	mov	r3, r7
    1c28:	e58d4000 	str	r4, [sp]
    1c2c:	ebfffcf9 	bl	1018 <_Unwind_VRS_Set>
    1c30:	e1a00007 	mov	r0, r7
    1c34:	ea0000c5 	b	1f50 <__gnu_unwind_execute+0x38c>
    1c38:	e2101080 	ands	r1, r0, #128	; 0x80
    1c3c:	1a000010 	bne	1c84 <__gnu_unwind_execute+0xc0>
    1c40:	e1a03001 	mov	r3, r1
    1c44:	e1a08100 	lsl	r8, r0, #2
    1c48:	e3a0200d 	mov	r2, #13
    1c4c:	e1a00005 	mov	r0, r5
    1c50:	e20880ff 	and	r8, r8, #255	; 0xff
    1c54:	e58da000 	str	sl, [sp]
    1c58:	ebfffcd3 	bl	fac <_Unwind_VRS_Get>
    1c5c:	e59d300c 	ldr	r3, [sp, #12]
    1c60:	e2888004 	add	r8, r8, #4
    1c64:	e3140040 	tst	r4, #64	; 0x40
    1c68:	10688003 	rsbne	r8, r8, r3
    1c6c:	00838008 	addeq	r8, r3, r8
    1c70:	e58d800c 	str	r8, [sp, #12]
    1c74:	e58da000 	str	sl, [sp]
    1c78:	e1a00005 	mov	r0, r5
    1c7c:	e3a01000 	mov	r1, #0
    1c80:	ea000024 	b	1d18 <__gnu_unwind_execute+0x154>
    1c84:	e20030f0 	and	r3, r0, #240	; 0xf0
    1c88:	e3530080 	cmp	r3, #128	; 0x80
    1c8c:	1a000011 	bne	1cd8 <__gnu_unwind_execute+0x114>
    1c90:	e1a04400 	lsl	r4, r0, #8
    1c94:	e1a00006 	mov	r0, r6
    1c98:	ebffffb3 	bl	1b6c <_Unwind_Backtrace+0x24>
    1c9c:	e1804004 	orr	r4, r0, r4
    1ca0:	e3540902 	cmp	r4, #32768	; 0x8000
    1ca4:	0a0000a8 	beq	1f4c <__gnu_unwind_execute+0x388>
    1ca8:	e3a01000 	mov	r1, #0
    1cac:	e1a02a04 	lsl	r2, r4, #20
    1cb0:	e1a00005 	mov	r0, r5
    1cb4:	e1a02822 	lsr	r2, r2, #16
    1cb8:	e1a03001 	mov	r3, r1
    1cbc:	ebfffddc 	bl	1434 <_Unwind_VRS_Pop>
    1cc0:	e1a08204 	lsl	r8, r4, #4
    1cc4:	e3500000 	cmp	r0, #0
    1cc8:	1a00009f 	bne	1f4c <__gnu_unwind_execute+0x388>
    1ccc:	e3180902 	tst	r8, #32768	; 0x8000
    1cd0:	13a07001 	movne	r7, #1
    1cd4:	eaffffc0 	b	1bdc <__gnu_unwind_execute+0x18>
    1cd8:	e3530090 	cmp	r3, #144	; 0x90
    1cdc:	1a000011 	bne	1d28 <__gnu_unwind_execute+0x164>
    1ce0:	e200200f 	and	r2, r0, #15
    1ce4:	e352000d 	cmp	r2, #13
    1ce8:	1352000f 	cmpne	r2, #15
    1cec:	13a08000 	movne	r8, #0
    1cf0:	03a08001 	moveq	r8, #1
    1cf4:	0a000094 	beq	1f4c <__gnu_unwind_execute+0x388>
    1cf8:	e1a01008 	mov	r1, r8
    1cfc:	e1a00005 	mov	r0, r5
    1d00:	e1a03008 	mov	r3, r8
    1d04:	e58da000 	str	sl, [sp]
    1d08:	ebfffca7 	bl	fac <_Unwind_VRS_Get>
    1d0c:	e1a00005 	mov	r0, r5
    1d10:	e1a01008 	mov	r1, r8
    1d14:	e58da000 	str	sl, [sp]
    1d18:	e3a0200d 	mov	r2, #13
    1d1c:	e1a03001 	mov	r3, r1
    1d20:	ebfffcbc 	bl	1018 <_Unwind_VRS_Set>
    1d24:	eaffffac 	b	1bdc <__gnu_unwind_execute+0x18>
    1d28:	e35300a0 	cmp	r3, #160	; 0xa0
    1d2c:	1a000008 	bne	1d54 <__gnu_unwind_execute+0x190>
    1d30:	e1e02000 	mvn	r2, r0
    1d34:	e2022007 	and	r2, r2, #7
    1d38:	e1a02259 	asr	r2, r9, r2
    1d3c:	e3100008 	tst	r0, #8
    1d40:	e2022eff 	and	r2, r2, #4080	; 0xff0
    1d44:	13822901 	orrne	r2, r2, #16384	; 0x4000
    1d48:	e1a00005 	mov	r0, r5
    1d4c:	e3a01000 	mov	r1, #0
    1d50:	ea00005d 	b	1ecc <__gnu_unwind_execute+0x308>
    1d54:	e35300b0 	cmp	r3, #176	; 0xb0
    1d58:	1a00003b 	bne	1e4c <__gnu_unwind_execute+0x288>
    1d5c:	e35000b1 	cmp	r0, #177	; 0xb1
    1d60:	1a000007 	bne	1d84 <__gnu_unwind_execute+0x1c0>
    1d64:	e1a00006 	mov	r0, r6
    1d68:	ebffff7f 	bl	1b6c <_Unwind_Backtrace+0x24>
    1d6c:	e2502000 	subs	r2, r0, #0
    1d70:	0a000075 	beq	1f4c <__gnu_unwind_execute+0x388>
    1d74:	e21210f0 	ands	r1, r2, #240	; 0xf0
    1d78:	1a000073 	bne	1f4c <__gnu_unwind_execute+0x388>
    1d7c:	e1a00005 	mov	r0, r5
    1d80:	ea000051 	b	1ecc <__gnu_unwind_execute+0x308>
    1d84:	e35000b2 	cmp	r0, #178	; 0xb2
    1d88:	1a000018 	bne	1df0 <__gnu_unwind_execute+0x22c>
    1d8c:	e3a01000 	mov	r1, #0
    1d90:	e3a0200d 	mov	r2, #13
    1d94:	e1a03001 	mov	r3, r1
    1d98:	e1a00005 	mov	r0, r5
    1d9c:	e58da000 	str	sl, [sp]
    1da0:	ebfffc81 	bl	fac <_Unwind_VRS_Get>
    1da4:	e1a00006 	mov	r0, r6
    1da8:	ebffff6f 	bl	1b6c <_Unwind_Backtrace+0x24>
    1dac:	e3a04002 	mov	r4, #2
    1db0:	ea000004 	b	1dc8 <__gnu_unwind_execute+0x204>
    1db4:	e0830410 	add	r0, r3, r0, lsl r4
    1db8:	e58d000c 	str	r0, [sp, #12]
    1dbc:	e1a00006 	mov	r0, r6
    1dc0:	e2844007 	add	r4, r4, #7
    1dc4:	ebffff68 	bl	1b6c <_Unwind_Backtrace+0x24>
    1dc8:	e2101080 	ands	r1, r0, #128	; 0x80
    1dcc:	e59d300c 	ldr	r3, [sp, #12]
    1dd0:	e200007f 	and	r0, r0, #127	; 0x7f
    1dd4:	1afffff6 	bne	1db4 <__gnu_unwind_execute+0x1f0>
    1dd8:	e2833f81 	add	r3, r3, #516	; 0x204
    1ddc:	e0830410 	add	r0, r3, r0, lsl r4
    1de0:	e58da000 	str	sl, [sp]
    1de4:	e58d000c 	str	r0, [sp, #12]
    1de8:	e1a00005 	mov	r0, r5
    1dec:	eaffffc9 	b	1d18 <__gnu_unwind_execute+0x154>
    1df0:	e35000b3 	cmp	r0, #179	; 0xb3
    1df4:	1a000007 	bne	1e18 <__gnu_unwind_execute+0x254>
    1df8:	e1a00006 	mov	r0, r6
    1dfc:	ebffff5a 	bl	1b6c <_Unwind_Backtrace+0x24>
    1e00:	e3a01001 	mov	r1, #1
    1e04:	e200300f 	and	r3, r0, #15
    1e08:	e20020f0 	and	r2, r0, #240	; 0xf0
    1e0c:	e2833001 	add	r3, r3, #1
    1e10:	e1a00005 	mov	r0, r5
    1e14:	ea000017 	b	1e78 <__gnu_unwind_execute+0x2b4>
    1e18:	e20030fc 	and	r3, r0, #252	; 0xfc
    1e1c:	e35300b4 	cmp	r3, #180	; 0xb4
    1e20:	02004003 	andeq	r4, r0, #3
    1e24:	12044007 	andne	r4, r4, #7
    1e28:	02842001 	addeq	r2, r4, #1
    1e2c:	12842001 	addne	r2, r4, #1
    1e30:	01a00005 	moveq	r0, r5
    1e34:	03a01002 	moveq	r1, #2
    1e38:	03822701 	orreq	r2, r2, #262144	; 0x40000
    1e3c:	11a00005 	movne	r0, r5
    1e40:	13a01001 	movne	r1, #1
    1e44:	13822702 	orrne	r2, r2, #524288	; 0x80000
    1e48:	ea00001f 	b	1ecc <__gnu_unwind_execute+0x308>
    1e4c:	e35300c0 	cmp	r3, #192	; 0xc0
    1e50:	1a000031 	bne	1f1c <__gnu_unwind_execute+0x358>
    1e54:	e35000c6 	cmp	r0, #198	; 0xc6
    1e58:	1a000008 	bne	1e80 <__gnu_unwind_execute+0x2bc>
    1e5c:	e1a00006 	mov	r0, r6
    1e60:	ebffff41 	bl	1b6c <_Unwind_Backtrace+0x24>
    1e64:	e3a01003 	mov	r1, #3
    1e68:	e200300f 	and	r3, r0, #15
    1e6c:	e20020f0 	and	r2, r0, #240	; 0xf0
    1e70:	e2833001 	add	r3, r3, #1
    1e74:	e1a00005 	mov	r0, r5
    1e78:	e1832602 	orr	r2, r3, r2, lsl #12
    1e7c:	ea000012 	b	1ecc <__gnu_unwind_execute+0x308>
    1e80:	e35000c7 	cmp	r0, #199	; 0xc7
    1e84:	1a000008 	bne	1eac <__gnu_unwind_execute+0x2e8>
    1e88:	e1a00006 	mov	r0, r6
    1e8c:	ebffff36 	bl	1b6c <_Unwind_Backtrace+0x24>
    1e90:	e2502000 	subs	r2, r0, #0
    1e94:	0a00002c 	beq	1f4c <__gnu_unwind_execute+0x388>
    1e98:	e21230f0 	ands	r3, r2, #240	; 0xf0
    1e9c:	1a00002a 	bne	1f4c <__gnu_unwind_execute+0x388>
    1ea0:	e1a00005 	mov	r0, r5
    1ea4:	e3a01004 	mov	r1, #4
    1ea8:	ea000024 	b	1f40 <__gnu_unwind_execute+0x37c>
    1eac:	e20030f8 	and	r3, r0, #248	; 0xf8
    1eb0:	e35300c0 	cmp	r3, #192	; 0xc0
    1eb4:	1a000006 	bne	1ed4 <__gnu_unwind_execute+0x310>
    1eb8:	e200400f 	and	r4, r0, #15
    1ebc:	e2842001 	add	r2, r4, #1
    1ec0:	e1a00005 	mov	r0, r5
    1ec4:	e3a01003 	mov	r1, #3
    1ec8:	e382280a 	orr	r2, r2, #655360	; 0xa0000
    1ecc:	e1a03001 	mov	r3, r1
    1ed0:	ea00001a 	b	1f40 <__gnu_unwind_execute+0x37c>
    1ed4:	e35000c8 	cmp	r0, #200	; 0xc8
    1ed8:	1a000004 	bne	1ef0 <__gnu_unwind_execute+0x32c>
    1edc:	e1a00006 	mov	r0, r6
    1ee0:	ebffff21 	bl	1b6c <_Unwind_Backtrace+0x24>
    1ee4:	e20020f0 	and	r2, r0, #240	; 0xf0
    1ee8:	e2822010 	add	r2, r2, #16
    1eec:	ea000004 	b	1f04 <__gnu_unwind_execute+0x340>
    1ef0:	e35000c9 	cmp	r0, #201	; 0xc9
    1ef4:	1a000014 	bne	1f4c <__gnu_unwind_execute+0x388>
    1ef8:	e1a00006 	mov	r0, r6
    1efc:	ebffff1a 	bl	1b6c <_Unwind_Backtrace+0x24>
    1f00:	e20020f0 	and	r2, r0, #240	; 0xf0
    1f04:	e200300f 	and	r3, r0, #15
    1f08:	e2833001 	add	r3, r3, #1
    1f0c:	e1a00005 	mov	r0, r5
    1f10:	e3a01001 	mov	r1, #1
    1f14:	e1832602 	orr	r2, r3, r2, lsl #12
    1f18:	ea000007 	b	1f3c <__gnu_unwind_execute+0x378>
    1f1c:	e20030f8 	and	r3, r0, #248	; 0xf8
    1f20:	e35300d0 	cmp	r3, #208	; 0xd0
    1f24:	1a000008 	bne	1f4c <__gnu_unwind_execute+0x388>
    1f28:	e2004007 	and	r4, r0, #7
    1f2c:	e2842001 	add	r2, r4, #1
    1f30:	e1a00005 	mov	r0, r5
    1f34:	e3a01001 	mov	r1, #1
    1f38:	e3822702 	orr	r2, r2, #524288	; 0x80000
    1f3c:	e3a03005 	mov	r3, #5
    1f40:	ebfffd3b 	bl	1434 <_Unwind_VRS_Pop>
    1f44:	e3500000 	cmp	r0, #0
    1f48:	0affff23 	beq	1bdc <__gnu_unwind_execute+0x18>
    1f4c:	e3a00009 	mov	r0, #9
    1f50:	e28dd010 	add	sp, sp, #16
    1f54:	e8bd87f0 	pop	{r4, r5, r6, r7, r8, r9, sl, pc}

00001f58 <__gnu_unwind_frame>:
    1f58:	e92d401f 	push	{r0, r1, r2, r3, r4, lr}
    1f5c:	e590304c 	ldr	r3, [r0, #76]	; 0x4c
    1f60:	e1a00001 	mov	r0, r1
    1f64:	e5932004 	ldr	r2, [r3, #4]
    1f68:	e28d1004 	add	r1, sp, #4
    1f6c:	e1a02402 	lsl	r2, r2, #8
    1f70:	e58d2004 	str	r2, [sp, #4]
    1f74:	e2832008 	add	r2, r3, #8
    1f78:	e58d2008 	str	r2, [sp, #8]
    1f7c:	e3a02003 	mov	r2, #3
    1f80:	e5cd200c 	strb	r2, [sp, #12]
    1f84:	e5d33007 	ldrb	r3, [r3, #7]
    1f88:	e5cd300d 	strb	r3, [sp, #13]
    1f8c:	ebffff0c 	bl	1bc4 <__gnu_unwind_execute>
    1f90:	e28dd014 	add	sp, sp, #20
    1f94:	e8bd8000 	ldmfd	sp!, {pc}

00001f98 <_Unwind_GetRegionStart>:
    1f98:	e92d401f 	push	{r0, r1, r2, r3, r4, lr}
    1f9c:	e3a01000 	mov	r1, #0
    1fa0:	e28d300c 	add	r3, sp, #12
    1fa4:	e58d3000 	str	r3, [sp]
    1fa8:	e3a0200c 	mov	r2, #12
    1fac:	e1a03001 	mov	r3, r1
    1fb0:	ebfffbfd 	bl	fac <_Unwind_VRS_Get>
    1fb4:	e59d300c 	ldr	r3, [sp, #12]
    1fb8:	e5930048 	ldr	r0, [r3, #72]	; 0x48
    1fbc:	e28dd014 	add	sp, sp, #20
    1fc0:	e8bd8000 	ldmfd	sp!, {pc}

00001fc4 <_Unwind_GetLanguageSpecificData>:
    1fc4:	e92d401f 	push	{r0, r1, r2, r3, r4, lr}
    1fc8:	e3a01000 	mov	r1, #0
    1fcc:	e28d300c 	add	r3, sp, #12
    1fd0:	e58d3000 	str	r3, [sp]
    1fd4:	e3a0200c 	mov	r2, #12
    1fd8:	e1a03001 	mov	r3, r1
    1fdc:	ebfffbf2 	bl	fac <_Unwind_VRS_Get>
    1fe0:	e59d300c 	ldr	r3, [sp, #12]
    1fe4:	e593304c 	ldr	r3, [r3, #76]	; 0x4c
    1fe8:	e5d32007 	ldrb	r2, [r3, #7]
    1fec:	e0833102 	add	r3, r3, r2, lsl #2
    1ff0:	e2830008 	add	r0, r3, #8
    1ff4:	e28dd014 	add	sp, sp, #20
    1ff8:	e8bd8000 	ldmfd	sp!, {pc}

00001ffc <_Unwind_GetDataRelBase>:
    1ffc:	e92d4008 	push	{r3, lr}
    2000:	ebfffae5 	bl	b9c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x48>

00002004 <_Unwind_GetTextRelBase>:
    2004:	e92d4008 	push	{r3, lr}
    2008:	ebfffae3 	bl	b9c <_Z58Java_com_example_myandroid_MainActivity_hellowWorldFromJNIP7_JNIEnvP8_jobject-0x48>

Disassembly of section .ARM.extab:

0000200c <.ARM.extab>:
    200c:	8101b2a1 	smlatbhi	r1, r1, r2, fp
    2010:	01aeb0b0 	strheq	fp, [lr, r0]!
    2014:	00000000 	andeq	r0, r0, r0
    2018:	8101263f 	tsthi	r1, pc, lsr r6
    201c:	845fb0b0 	ldrbhi	fp, [pc], #-176	; 2024 <_Unwind_GetTextRelBase+0x20>
    2020:	00000000 	andeq	r0, r0, r0
    2024:	8101b108 	tsthi	r1, r8, lsl #2
    2028:	8400b0b0 	strhi	fp, [r0], #-176	; 0xb0
    202c:	00000000 	andeq	r0, r0, r0
    2030:	8101b108 	tsthi	r1, r8, lsl #2
    2034:	8400b0b0 	strhi	fp, [r0], #-176	; 0xb0
    2038:	00000000 	andeq	r0, r0, r0
    203c:	8101b108 	tsthi	r1, r8, lsl #2
    2040:	8400b0b0 	strhi	fp, [r0], #-176	; 0xb0
    2044:	00000000 	andeq	r0, r0, r0

Disassembly of section .ARM.exidx:

00002048 <.ARM.exidx>:
    2048:	7fffeb9c 	svcvc	0x00ffeb9c
    204c:	80b0b0b0 	ldrhthi	fp, [r0], r0
    2050:	7fffebb0 	svcvc	0x00ffebb0
    2054:	8004afb0 			; <UNDEFINED> instruction: 0x8004afb0
    2058:	7fffed7c 	svcvc	0x00ffed7c
    205c:	80a8b0b0 	strhhi	fp, [r8], r0	; <UNPREDICTABLE>
    2060:	7fffede0 	svcvc	0x00ffede0
    2064:	7fffffa8 	svcvc	0x00ffffa8
    2068:	7fffeeec 	svcvc	0x00ffeeec
    206c:	80b108a9 	adcshi	r0, r1, r9, lsr #17
    2070:	7fffef3c 	svcvc	0x00ffef3c
    2074:	80b0b0b0 	ldrhthi	fp, [r0], r0
    2078:	7fffef78 	svcvc	0x00ffef78
    207c:	80b10fa8 	adcshi	r0, r1, r8, lsr #31
    2080:	7fffef98 	svcvc	0x00ffef98
    2084:	80b0b0b0 	ldrhthi	fp, [r0], r0
    2088:	7fffefd4 	svcvc	0x00ffefd4
    208c:	80b10fa8 	adcshi	r0, r1, r8, lsr #31
    2090:	7fffeff8 	svcvc	0x00ffeff8
    2094:	8008afb0 			; <UNDEFINED> instruction: 0x8008afb0
    2098:	7ffff384 	svcvc	0x00fff384
    209c:	80b0b0b0 	ldrhthi	fp, [r0], r0
    20a0:	7ffff394 	svcvc	0x00fff394
    20a4:	7fffff74 	svcvc	0x00ffff74
    20a8:	7ffff6e4 	svcvc	0x00fff6e4
    20ac:	80b0b0b0 	ldrhthi	fp, [r0], r0
    20b0:	7ffff6e4 	svcvc	0x00fff6e4
    20b4:	80b210ab 	adcshi	r1, r2, fp, lsr #1
    20b8:	7ffff780 	svcvc	0x00fff780
    20bc:	80b0b0b0 	ldrhthi	fp, [r0], r0
    20c0:	7ffff794 	svcvc	0x00fff794
    20c4:	80b108a9 	adcshi	r0, r1, r9, lsr #17
    20c8:	7ffff7f8 	svcvc	0x00fff7f8
    20cc:	80b0b0b0 	ldrhthi	fp, [r0], r0
    20d0:	7ffff814 	svcvc	0x00fff814
    20d4:	7fffff50 	svcvc	0x00ffff50
    20d8:	7ffff82c 	svcvc	0x00fff82c
    20dc:	80b225aa 	adcshi	r2, r2, sl, lsr #11
    20e0:	7ffff8e4 	svcvc	0x00fff8e4
    20e4:	00000001 	andeq	r0, r0, r1
    20e8:	7ffffa84 	svcvc	0x00fffa84
    20ec:	80b0b0b0 	ldrhthi	fp, [r0], r0
    20f0:	7ffffad4 	svcvc	0x00fffad4
    20f4:	80b10fae 	adcshi	r0, r1, lr, lsr #31
    20f8:	7ffffe60 	svcvc	0x00fffe60
    20fc:	80b10fa8 	adcshi	r0, r1, r8, lsr #31
    2100:	7ffffefc 	svcvc	0x00fffefc
    2104:	7fffff2c 	svcvc	0x00ffff2c
    2108:	7ffffefc 	svcvc	0x00fffefc
    210c:	7fffff30 	svcvc	0x00ffff30
    2110:	7ffffefc 	svcvc	0x00fffefc
    2114:	00000001 	andeq	r0, r0, r1

Disassembly of section .fini_array:

00003eb8 <.fini_array>:
    3eb8:	00000bd4 	ldrdeq	r0, [r0], -r4
    3ebc:	00000000 	andeq	r0, r0, r0

Disassembly of section .init_array:

00003ec0 <.init_array>:
    3ec0:	00000000 	andeq	r0, r0, r0

Disassembly of section .dynamic:

00003ec4 <.dynamic>:
    3ec4:	00000003 	andeq	r0, r0, r3
    3ec8:	00003fd8 	ldrdeq	r3, [r0], -r8
    3ecc:	00000002 	andeq	r0, r0, r2
    3ed0:	00000038 	andeq	r0, r0, r8, lsr r0
    3ed4:	00000017 	andeq	r0, r0, r7, lsl r0
    3ed8:	00000b20 	andeq	r0, r0, r0, lsr #22
    3edc:	00000014 	andeq	r0, r0, r4, lsl r0
    3ee0:	00000011 	andeq	r0, r0, r1, lsl r0
    3ee4:	00000011 	andeq	r0, r0, r1, lsl r0
    3ee8:	00000ae0 	andeq	r0, r0, r0, ror #21
    3eec:	00000012 	andeq	r0, r0, r2, lsl r0
    3ef0:	00000040 	andeq	r0, r0, r0, asr #32
    3ef4:	00000013 	andeq	r0, r0, r3, lsl r0
    3ef8:	00000008 	andeq	r0, r0, r8
    3efc:	6ffffffa 	svcvs	0x00fffffa
    3f00:	00000006 	andeq	r0, r0, r6
    3f04:	00000006 	andeq	r0, r0, r6
    3f08:	00000114 	andeq	r0, r0, r4, lsl r1
    3f0c:	0000000b 	andeq	r0, r0, fp
    3f10:	00000010 	andeq	r0, r0, r0, lsl r0
    3f14:	00000005 	andeq	r0, r0, r5
    3f18:	00000484 	andeq	r0, r0, r4, lsl #9
    3f1c:	0000000a 	andeq	r0, r0, sl
    3f20:	000004e3 	andeq	r0, r0, r3, ror #9
    3f24:	00000004 	andeq	r0, r0, r4
    3f28:	00000968 	andeq	r0, r0, r8, ror #18
    3f2c:	00000001 	andeq	r0, r0, r1
    3f30:	000004ac 	andeq	r0, r0, ip, lsr #9
    3f34:	00000001 	andeq	r0, r0, r1
    3f38:	000004b9 			; <UNDEFINED> instruction: 0x000004b9
    3f3c:	00000001 	andeq	r0, r0, r1
    3f40:	000004c1 	andeq	r0, r0, r1, asr #9
    3f44:	00000001 	andeq	r0, r0, r1
    3f48:	000004c9 	andeq	r0, r0, r9, asr #9
    3f4c:	0000000e 	andeq	r0, r0, lr
    3f50:	000004d2 	ldrdeq	r0, [r0], -r2
    3f54:	0000001a 	andeq	r0, r0, sl, lsl r0
    3f58:	00003eb8 			; <UNDEFINED> instruction: 0x00003eb8
    3f5c:	0000001c 	andeq	r0, r0, ip, lsl r0
    3f60:	00000008 	andeq	r0, r0, r8
    3f64:	00000019 	andeq	r0, r0, r9, lsl r0
    3f68:	00003ec0 	andeq	r3, r0, r0, asr #29
    3f6c:	0000001b 	andeq	r0, r0, fp, lsl r0
    3f70:	00000004 	andeq	r0, r0, r4
    3f74:	00000010 	andeq	r0, r0, r0, lsl r0
    3f78:	00000000 	andeq	r0, r0, r0
    3f7c:	0000001e 	andeq	r0, r0, lr, lsl r0
    3f80:	0000000a 	andeq	r0, r0, sl
    3f84:	6ffffffb 	svcvs	0x00fffffb
    3f88:	00000001 	andeq	r0, r0, r1
	...

Disassembly of section .got:

00003fbc <.got>:
    3fbc:	00000000 	andeq	r0, r0, r0
    3fc0:	00002118 	andeq	r2, r0, r8, lsl r1
    3fc4:	00002048 	andeq	r2, r0, r8, asr #32
    3fc8:	0000142c 	andeq	r1, r0, ip, lsr #8
    3fcc:	00001424 	andeq	r1, r0, r4, lsr #8
    3fd0:	0000141c 	andeq	r1, r0, ip, lsl r4
	...
    3fe4:	00000b58 	andeq	r0, r0, r8, asr fp
    3fe8:	00000b58 	andeq	r0, r0, r8, asr fp
    3fec:	00000b58 	andeq	r0, r0, r8, asr fp
    3ff0:	00000b58 	andeq	r0, r0, r8, asr fp
    3ff4:	00000b58 	andeq	r0, r0, r8, asr fp
    3ff8:	00000b58 	andeq	r0, r0, r8, asr fp
    3ffc:	00000b58 	andeq	r0, r0, r8, asr fp

Disassembly of section .data:

00004000 <.data>:
    4000:	00000000 	andeq	r0, r0, r0

Disassembly of section .comment:

00000000 <.comment>:
   0:	43434700 	movtmi	r4, #14080	; 0x3700
   4:	4728203a 			; <UNDEFINED> instruction: 0x4728203a
   8:	2029554e 	eorcs	r5, r9, lr, asr #10
   c:	20362e34 	eorscs	r2, r6, r4, lsr lr
  10:	32313032 	eorscc	r3, r1, #50	; 0x32
  14:	36303130 			; <UNDEFINED> instruction: 0x36303130
  18:	72702820 	rsbsvc	r2, r0, #32, 16	; 0x200000
  1c:	6c657265 	sfmvs	f7, 2, [r5], #-404	; 0xfffffe6c
  20:	65736165 	ldrbvs	r6, [r3, #-357]!	; 0x165
  24:	Address 0x00000024 is out of bounds.


Disassembly of section .note.gnu.gold-version:

00000000 <.note.gnu.gold-version>:
   0:	00000004 	andeq	r0, r0, r4
   4:	00000009 	andeq	r0, r0, r9
   8:	00000004 	andeq	r0, r0, r4
   c:	00554e47 	subseq	r4, r5, r7, asr #28
  10:	646c6f67 	strbtvs	r6, [ip], #-3943	; 0xf67
  14:	312e3120 	teqcc	lr, r0, lsr #2
  18:	00000030 	andeq	r0, r0, r0, lsr r0

Disassembly of section .ARM.attributes:

00000000 <.ARM.attributes>:
   0:	00002c41 	andeq	r2, r0, r1, asr #24
   4:	61656100 	cmnvs	r5, r0, lsl #2
   8:	01006962 	tsteq	r0, r2, ror #18
   c:	00000022 	andeq	r0, r0, r2, lsr #32
  10:	45543505 	ldrbmi	r3, [r4, #-1285]	; 0x505
  14:	08040600 	stmdaeq	r4, {r9, sl}
  18:	0a010901 	beq	42424 <__bss_start+0x3e420>
  1c:	14041202 	strne	r1, [r4], #-514	; 0x202
  20:	17011501 	strne	r1, [r1, -r1, lsl #10]
  24:	1a011803 	bne	46038 <__bss_start+0x42034>
  28:	2c021e02 	stccs	14, cr1, [r2], {2}
  2c:	Address 0x0000002c is out of bounds.

