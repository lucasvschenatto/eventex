import {activity} from "../../domain/activity/activity";
import {Injectable} from "angular2/core";
import {Http, Response, Headers, RequestOptions} from "angular2/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

@Injectable()
export class ActivityService {
    constructor(private _http: Http) { }
    private _apiUrl: string = "https://eventex.herokuapp.com/activity";

    getList() {
        return this._http.get(this._apiUrl)
            .map(res => res.json())
            .catch(this.throwError);
    }

    private throwError(response) {
        return Observable.throw(response.json().error || "Server error")
    }
}
