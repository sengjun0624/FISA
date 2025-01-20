export default async function Docs({ params }) {

    const paramsValue = await params;
    console.log(paramsValue);

    if (paramsValue.slug.length === 2) {// /docs/feature1/concept1 경로일 경우,
        return (
            <h1>Viewing docs for feature <span className="text-red-500">{paramsValue.slug[0]}</span> and concept <span className="text-blue-500">{paramsValue.slug[1]}</span></h1>
        )
    } else if (paramsValue.slug.length === 1) { // /docs/feature1 경로일 경우,
        return <h1>Viewing docs for feature {paramsValue.slug[0]}</h1>
    }

    return (
        <div>Docs 메인 페이지</div>
    );
}