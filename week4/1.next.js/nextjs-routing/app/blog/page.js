export default async function PageName() {
    await new Promise(resolve => setTimeout(resolve, 2000));
    return (
        <div>
            blog Main
        </div>
   );
}