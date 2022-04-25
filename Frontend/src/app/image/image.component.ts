import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Image } from '../modal/Image';
import { ImageService } from '../services/image.service';

@Component({
    selector: 'app-image',
    templateUrl: './image.component.html',
    styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {

    images: Image[]=[];
    constructor(
        private imageService: ImageService,
        private location : Location,
    ) { }

    ngOnInit(): void {
        this.getImageAll();
    }
    getImageAll(): void {
        this.imageService.getAllImages().subscribe(images => this.images = images);
    }

    goBack(){
        this.location.back();
    }
}
