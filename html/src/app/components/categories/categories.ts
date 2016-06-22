import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {CategoryService} from '../../services/category/category-service';
import {category} from '../../domain/category/category';

@Component({
    selector: 'categories',
    templateUrl: 'app/components/categories/categories.html',
    directives: [RdWidget, RdLoading]
})
export class Categories implements OnInit {
    public domain: category;
    public categories: category[] = [];

    constructor(private _service: CategoryService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.categories = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new category();

        return false;
    }

    public onBack(): boolean {
        this.domain = null;

        return false;
    }

    public onSave(): boolean {
        this._service.save(this.domain);

        return false;
    }
}
